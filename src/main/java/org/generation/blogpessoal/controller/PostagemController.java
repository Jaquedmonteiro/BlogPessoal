package org.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogpessoal.model.Postagem;
import org.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*Informa ao Spring que esta Classe é um controlador, detectando todas as requisiões do mapeamento feita via URL (navegador ou postman)*/
<<<<<<< HEAD
@RequestMapping("/postagens") /*Solicitação do mapeamento feito via URL*/
@CrossOrigin("*")  /*Aceitará requisiões de qualquer origem*/
public class PostagemController {
	
	@Autowired /*Injeção de dependências*/
	private PostagemRepository repository;
=======
@RequestMapping("/postagens")  /*Solicitação do mapeamento feito via URL*/
@CrossOrigin("*") /*Aceitará requisiões de qualquer origem*/
public class PostagemController {
	
	@Autowired /*Injeção de dependências*/
	private PostagemRepository repositoty;
>>>>>>> 3b06d4dcfb79312ea6e938c3c99bd86cadbdf313
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetALL(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById( @PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@Valid @RequestBody  Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put ( @RequestBody  Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
