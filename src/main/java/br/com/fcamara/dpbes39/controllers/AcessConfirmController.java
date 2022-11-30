package br.com.fcamara.dpbes39.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamara.dpbes39.entities.NewUsers;
import br.com.fcamara.dpbes39.repositories.AcessConfirmRepository;

@RestController
@RequestMapping("/acesso")
public class AcessConfirmController {

	@Autowired
	private AcessConfirmRepository acessConfirmRepository;

	@GetMapping("/confirmacao")
	public NewUsers emailConfirmacao() {
		return new NewUsers("Jackson", "jacks@mail");
	}

	@PostMapping
	public NewUsers novoUsuario(@RequestParam String nome, String email) {
		NewUsers newusers = new NewUsers(nome, email);
		acessConfirmRepository.save(newusers);
		return newusers;
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity emailConfirmacaPorId(@PathVariable Integer id) {
		// retornar um usuario existente
		return acessConfirmRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(path = { "/all" })
	public Iterable<NewUsers> findAll() {
		return acessConfirmRepository.findAll();
	}

	@GetMapping(path = { "/email" })
	public NewUsers emailConfirmacaPorEmail(@RequestParam(name = "email") String email) {
		return new NewUsers("Jackson", "jacks.strong@gmail.com");
	}

	// recebidos parametros
	@PostMapping(path = { "{nome}/{email}/add" })
	public NewUsers addUser(@PathVariable("id") Integer id, @PathVariable("nome") String nome,
			@PathVariable("email") String email) {
		// dados recebidos do banco
		Optional<NewUsers> newusers = acessConfirmRepository.findById(id);

		// dados recebidos da entidade
		NewUsers newuserss = newusers.get();
		System.out.println("Novo usuário: " + newuserss);
		if (newuserss.getNome().contains(nome) && newuserss.getEmail().contains(email)) {
			return newuserss;
		} else {
			throw new Error("Usuario não encontrado ou não cadastrado");
		}

	}

	/*
	 * recebidos parametros, NAC.
	 * 
	 */
	@GetMapping(path = { "/remail" })
	public NewUsers encontrarPorEmail(
			@RequestParam(name = "nome") String nome,
			@RequestParam(name = "email") String email, 
			@PathVariable("id") Integer id) {
		// dados recebidos do banco
		Optional<NewUsers> newusers = acessConfirmRepository.findById(id);
		// Instanciando newuserss
		NewUsers newuserss = newusers.get();

		if (newusers.filter(item -> item.getEmail() == email) != null) {
			return newuserss;
		} else {
			throw new Error("Usuario não encontrado ou não cadastrado");

		}

	}

}
