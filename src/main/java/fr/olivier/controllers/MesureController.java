package fr.olivier.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.olivier.entite.Mesure;

@RestController
@RequestMapping("/mesures")
public class MesureController {

	
	@GetMapping
	public List<Mesure> obtenirLesMesures(){
		
		return null;
		
	}
}
