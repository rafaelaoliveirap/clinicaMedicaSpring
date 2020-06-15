package com.generation.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.generation.clinica.model.FichaModel;
import com.generation.clinica.repository.FichaRepository;

public class FichaController {
	@Autowired
	private FichaRepository repository;
	
	@GetMapping("/{codigoFicha}")
	 public ResponseEntity<FichaModel> GetById(@PathVariable long codigoFicha){
	  return repository.findById(codigoFicha).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<FichaModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<FichaModel> Post (@RequestBody FichaModel ficha){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(ficha));
	}
	
	@PutMapping
	public ResponseEntity<FichaModel> Put (@RequestBody FichaModel ficha){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(ficha));
	}
	@DeleteMapping("/{codigoFicha}")
	public void deleteUsuario (@PathVariable long codigoFicha){
		  repository.deleteById(codigoFicha);
	}
}
