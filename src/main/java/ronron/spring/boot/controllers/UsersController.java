package ronron.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ronron.spring.boot.model.entities.Users;
import ronron.spring.boot.services.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/userscreator")
public class UsersController {

	@Autowired
	private UserService userService;

	@PostMapping
	@PutMapping
	public  @ResponseBody Users newUser(@Valid Users user) {
          return userService.save(user);
	}
	
	
	@GetMapping("/buscar")
	public Iterable<Users> obterUsuario() {
		return userService.obterUsuarios();
	}
	
//	@GetMapping("/{id}")
//	public Users obterUsuarioPorId1(@PathVariable int id) {
//		return new Users(id, "Maria", "987.654.321-00");
//	}
	
//	@GetMapping
//	public Users obterUsuarioPorId2(
//			@RequestParam(name = "id") int id) {
//		return new Users(id, "Joao Augusto", "111.222.333-44");
//	}

}
