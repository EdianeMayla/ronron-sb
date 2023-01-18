package ronron.spring.boot.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ronron.spring.boot.model.entities.Animals;
import ronron.spring.boot.services.AnimalsService;

@RestController
@RequestMapping("/api/animals")
public class AnimalsController {
	
	@Autowired
	private AnimalsService animalsService;
	
	//usando varios metodos em uma unica funcao
	//@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	
	
	@PostMapping
	@PutMapping
	public  @ResponseBody Animals newAnimal(@Valid Animals animal) {
          return animalsService.save(animal);
    }
	
	
	//buscando os animais filtrados
	@GetMapping
	public Iterable<Animals> getAnimal(@RequestParam String type, @RequestParam String gender, @RequestParam String collors) {
		return animalsService.getAnimal(type, gender, collors);
	}
	
	
	
//	@GetMapping
//	public Users obterUsuarioPorId2(
//			@RequestParam(name = "id") int id) {
//		return new Users(id, "Joao Augusto", "111.222.333-44");
//	}
	
	
	//fazendo a consulta por parte do nome do produto
	//@GetMapping(path="/name/{namePart}")
//	public Iterable <Animals> getAnimal(@PathVariable String namePart) {
//		//Ignorando letras maiusculas
//		//return animaisRepository.findByNomeContainingIgnoreCase(parteNome);
//		//outra forma de consulta
//		return animalsRepository.searchByNameLike(namePart);
//	}
	

	//definindo a quantidade de dados por pagina
//	@GetMapping(path = "/page/{pageNumber}")
//	public Iterable <Animals> getAnimalbyPage(
//		@PathVariable int pageNumber, @PathVariable int qtdofPage) {
//	  if(qtdofPage <= 5 ) qtdofPage =5; //regra para limitar o  numero de paginas a serem mostradas
//	  Pageable page = PageRequest.of(pageNumber, qtdofPage);
//		 return animalsService.findAll(page);
//	}
//
//	//buscando produtos por id
//	@GetMapping(path="/{id}")
//	public Optional<Animals> getAnimalById(@PathVariable int id) {
//		return animalsService.findById(id);
//	}
//
//	//alterando produto
////	@PutMapping
////	public Produto alterarProduto(@Valid Produto produto) {
////		animaisRepository.save(produto);
////		return produto;
////	}
//
//	//excluindo produto
//	@DeleteMapping(path = "/{id}")
//	public void deleteAnimal(@PathVariable int id) {
//		animalsService.deleteById(id);
//	}
}
