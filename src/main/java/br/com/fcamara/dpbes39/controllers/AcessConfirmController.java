package br.com.fcamara.dpbes39.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamara.dpbes39.entities.NewUsers;

@RestController
@RequestMapping("/acesso")
public class AcessConfirmController {
	
	@GetMapping("/confirmacao")
	public NewUsers emailConfirmacao() {
		return new NewUsers("Jackson");		
	}
	
	@GetMapping("/{id}")
	public NewUsers emailConfirmacaPorId(@PathVariable int id) {
		return new NewUsers(1L,"Jackson","jacks.strong@gmail.com");		
	}
	
	@GetMapping
	public NewUsers emailConfirmacaPorEmail(
			@RequestParam (name= "email") String email) {
		return new NewUsers(1L,"Jackson","jacks.strong@gmail.com");		
	}

	

}
