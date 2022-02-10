package com.chaBebe.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chaBebe.models.Presente;
import com.chaBebe.service.PresenteService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/presentes")
public class PresenteController {
	
	private static final String ID = "/{id}";
	
	@Autowired
	private PresenteService service;

	@GetMapping
	public ResponseEntity<List<Presente>> findAll(){	
		
		return ResponseEntity.ok()
				.body(service.findAll().stream()						
						.collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<Presente> create(@RequestBody Presente presente) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path(ID).buildAndExpand(service.create(presente)).toUri();
		return ResponseEntity.created(uri).build();
	}
}
