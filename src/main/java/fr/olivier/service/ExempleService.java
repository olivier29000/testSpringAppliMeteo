package fr.olivier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.olivier.entites.Exemple;
import fr.olivier.repository.ExempleRepository;

@Service
public class ExempleService {
	
	@Autowired
	ExempleRepository exempleRepository;
	
	public Exemple insererListeDeExemple(Exemple exemple){
		
		exempleRepository.save(exemple);
		
		return exemple;
		
	}

}
