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

import br.com.fcamara.dpbes39.entities.Medias;
import br.com.fcamara.dpbes39.repositories.MediaRepository;

@RestController
@RequestMapping("/api/medias")
public class MediaController {


	@Autowired
	private MediaRepository mediaRepository;
		
	@PostMapping
	public Medias novamedia(@RequestParam String type, String link, String duration) {
		Medias media = new Medias(type,link,duration);		
		mediaRepository.save(media);		
		return media;				
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable Integer id){
	   return mediaRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/all"})
	public Iterable<Medias> findAll(){
	   return mediaRepository.findAll();	       
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Integer id) {
	   return mediaRepository.findById(id)
	           .map(record -> {
	        	   mediaRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	

}
