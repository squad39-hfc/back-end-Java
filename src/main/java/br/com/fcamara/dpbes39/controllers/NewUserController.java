package br.com.fcamara.dpbes39.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamara.dpbes39.entities.NewUsers;
import br.com.fcamara.dpbes39.repositories.NewUserRepository;

@RestController
@RequestMapping("/api/usuario")
public class NewUserController {

	@Autowired
	private NewUserRepository newuserrepository;		
	
	@PostMapping
	public NewUsers novanewuser(@RequestParam String nome) {
		NewUsers newuser = new NewUsers(nome);		
		newuserrepository.save(newuser);		
		return newuser;				
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable Integer id){
	   return newuserrepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/all"})
	public Iterable<NewUsers> findAll(){
	   return newuserrepository.findAll();	       
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id,
	                                      @RequestBody NewUsers newuser) {
	   return newuserrepository.findById(id)
	           .map(record -> {
	               record.setNome(newuser.getNome());
	               NewUsers updated = newuserrepository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Integer id) {
	   return newuserrepository.findById(id)
	           .map(record -> {
	        	   newuserrepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	

}
