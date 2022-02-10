package com.chaBebe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaBebe.models.Presente;
import com.chaBebe.repository.PresenteRepository;

@Service
public class PresenteService {
	
	@Autowired
	private PresenteRepository presenteRepository;
	
	
	public List<Presente> findAll() {
		return presenteRepository.findAll();
	}
	
	public Presente create(Presente presente) {
		return presenteRepository.save(presente);
	}


}
