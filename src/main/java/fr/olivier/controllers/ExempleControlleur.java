package fr.olivier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.olivier.entites.Exemple;
import fr.olivier.service.ExempleService;

@RestController
@RequestMapping("/exemple")
public class ExempleControlleur {
	
	@Autowired
	ExempleService exempleService;
	
	@GetMapping
	public Exemple obtenirListeDesExemples(){
		
		
		return exempleService.insererListeDeExemple(new Exemple("hvbhkb","hjvh"));
		
	}

}
