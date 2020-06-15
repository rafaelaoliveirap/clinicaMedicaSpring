package com.generation.clinica.controller;

import java.util.List;

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

import com.generation.clinica.model.PacienteModel;
import com.generation.clinica.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
@CrossOrigin("*")


public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	
	@GetMapping("/{codigoPaciente}")
	 public ResponseEntity<PacienteModel> GetById(@PathVariable long codigoPaciente){
	  return repository.findById(codigoPaciente).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	  
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/paciente{nome}")
	public ResponseEntity<List<PacienteModel>> 
	getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<PacienteModel> Post (@RequestBody PacienteModel paciente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(paciente));
	}
	
	@PutMapping
	public ResponseEntity<PacienteModel> Put (@RequestBody PacienteModel paciente){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(paciente));
	}
	@DeleteMapping("/{codigoPaciente}")
	public void deleteUsuario (@PathVariable long codigoPaciente){
		  repository.deleteById(codigoPaciente);
	}

}
