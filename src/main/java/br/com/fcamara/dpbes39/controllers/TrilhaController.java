package br.com.fcamara.dpbes39.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import br.com.fcamara.dpbes39.entities.Trilhas;
import br.com.fcamara.dpbes39.repositories.ConteudoRepository;
import br.com.fcamara.dpbes39.repositories.TrilhaRepository;

@RestController
@RequestMapping("/api/trilhas")
@CrossOrigin(origins = "http://localhost:3000")
public class TrilhaController {

	@Autowired
	private TrilhaRepository trilhaRepository;

	@Autowired
	private ConteudoRepository conteudoRepository;

	// Função retorna uma trilha
	@PostMapping
	public Trilhas novaTrilha(@RequestParam String nome) {
		Trilhas trilha = new Trilhas(nome);	
		trilhaRepository.save(trilha);
		return trilha;
	}

	// Função progresso
	//////////////////////////////
	public Boolean statusConteudo(@RequestBody Conteudos conteudo) {
            //true or false		
		boolean fim = conteudo.isFinalizado();
		if(conteudo.isFinalizado()) {
			return fim;

		}else {			
			throw new Error("Conteudo em progresso");
		}	
		
	}
	
	//////////////////////////////
	@GetMapping(path = { "/{id}/conteudos/{idConteudo}/progresso" })
	public Trilhas barraDeprogresso(@PathVariable("id") Integer id, @PathVariable("idConteudo") Integer idConteudo,
			@RequestBody Trilhas trilha) {
		// Optional<Trilhas> trilha = trilhaRepository.findById(id);
		Optional<Conteudos> conteudos = conteudoRepository.findById(idConteudo);

		////////////////////////////////////////////
		Trilhas trilhas = new Trilhas();
		boolean concluido = false;

		if (trilhas.getConteudos().stream().anyMatch(item -> item.getId() == idConteudo)) {
			for (int i = 0; i <= 100; i += 3) {
				trilhas.setIdTrilha(trilha.getProgresso());
				trilhaRepository.save(trilhas);
			}

		} else {
			throw new Error("Trilha sem progresso");
		}
		return trilhas;
	}

	//////////////////////////////

	@PostMapping(path = { "/{id}/conteudos/{idConteudo}/add" })
	public Trilhas addConteudoEmTrilha(@PathVariable("id") Integer id, @PathVariable("idConteudo") Integer idConteudo) {
		Optional<Trilhas> trilha = trilhaRepository.findById(id);
		Optional<Conteudos> conteudos = conteudoRepository.findById(idConteudo);

		if (trilha.isEmpty()) {
			throw new Error("Trilha não encontrada");
		}
		if (conteudos.isEmpty()) {
			throw new Error("Conteudo não encontrada");
		}

		Trilhas trilhas = trilha.get();
		trilhas.getConteudos().add(conteudos.get());
		trilhaRepository.save(trilhas);
		return trilhas;

	}
	
	@DeleteMapping(path = { "/{id}/conteudos/{idConteudo}/delete" })
	public Trilhas deleteConteudoEmTrilha(@PathVariable("id") Integer id,
			@PathVariable("idConteudo") Integer idConteudo) {
		Optional<Trilhas> trilha = trilhaRepository.findById(id);
		Optional<Conteudos> conteudos = conteudoRepository.findById(idConteudo);

		if (trilha.isEmpty()) {
			throw new Error("Trilha não encontrada");
		}

		Trilhas trilhas = trilha.get();
		if (trilhas.getConteudos().stream().anyMatch(item -> item.getId() == idConteudo)) {
			trilhas.getConteudos().remove(
					trilhas.getConteudos().stream().filter(item -> item.getId() == idConteudo).findFirst().get());
		} else {
			throw new Error("Conteudo não encontrada");
		}

		trilhaRepository.save(trilhas);

		return trilhas;

	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable Integer id) {
		return trilhaRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = { "/all" })
	public Iterable<Trilhas> findAll() {
		return trilhaRepository.findAll();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Trilhas trilha) {
		return trilhaRepository.findById(id).map(record -> {
			record.setNome(trilha.getNome());
			Trilhas updated = trilhaRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return trilhaRepository.findById(id).map(record -> {
			trilhaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
