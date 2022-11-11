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

import br.com.fcamara.dpbes39.entities.Conteudos;
import br.com.fcamara.dpbes39.repositories.ConteudoRepository;




@RestController
@RequestMapping("/api/conteudos")
public class ConteudoController {


		@Autowired
		private ConteudoRepository conteudoRepository;		
		
		@PostMapping
		public Conteudos novaConteudo(@RequestParam String nome) {
			Conteudos conteudo = new Conteudos(nome);		
			conteudoRepository.save(conteudo);		
			return conteudo;				
		}
		
		@GetMapping(path = {"/{id}"})
		public ResponseEntity findById(@PathVariable Integer id){
		   return conteudoRepository.findById(id)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping(path = {"/all"})
		public Iterable<Conteudos> findAll(){
		   return conteudoRepository.findAll();	       
		}
		
		
		@PutMapping(value="/{id}")
		public ResponseEntity update(@PathVariable("id") Integer id,
		                                      @RequestBody Conteudos conteudo) {
		   return conteudoRepository.findById(id)
		           .map(record -> {
		               record.setNome(conteudo.getNome());
		               Conteudos updated = conteudoRepository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping(path ={"/{id}"})
		public ResponseEntity <?> delete(@PathVariable Integer id) {
		   return conteudoRepository.findById(id)
		           .map(record -> {
		        	   conteudoRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}
		

	}
