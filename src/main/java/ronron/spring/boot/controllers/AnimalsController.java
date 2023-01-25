package ronron.spring.boot.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ronron.spring.boot.model.entities.Animals;
import ronron.spring.boot.model.entities.Users;
import ronron.spring.boot.model.enuns.Situation;
import ronron.spring.boot.services.AnimalsService;

@RestController
@RequestMapping("/animals")
public class AnimalsController {
	
	@Autowired
	private AnimalsService animalsService;

	@PostMapping
	public ResponseEntity<Animals> newAnimal(Authentication authentication,@RequestBody Animals animal) {
		Users user = (Users) authentication.getPrincipal();
		return  ResponseEntity.ok(animalsService.save(user, animal));
    }

	@PutMapping("/{id}")
	public  @ResponseBody Animals animalUpdate(Authentication authentication, @PathVariable Integer id, @Valid @RequestBody Animals animal) {
		Users user = (Users) authentication.getPrincipal();
		return animalsService.animalUpdate(user, id, animal);
	}
	//buscando os animais filtrados
	@GetMapping(path="/search")
	public Iterable<Animals> search(@RequestParam String type, @RequestParam String gender, @RequestParam String collors) {
		return animalsService.search(type, gender, collors);
	}

	@GetMapping("/lost")
	public Iterable<Animals> searchLost() {
		return animalsService.searchLost(false);
	}

	@GetMapping("/found")
	public Iterable<Animals> searchBySituation(@RequestParam Situation situation) {
		return animalsService.searchBySituation(situation);
	}

	@GetMapping(path="/myanimals")
	public Iterable<Animals> findByUser(Authentication authentication) {
		Users user = (Users) authentication.getPrincipal();
		return animalsService.findByUser(user);
	}

}
