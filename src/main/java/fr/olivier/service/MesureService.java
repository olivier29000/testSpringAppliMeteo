package fr.olivier.service;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.olivier.entite.Mesure;
import fr.olivier.repository.MesureRepository;

@Service
public class MesureService {
	
	@Autowired
	MesureRepository mesureRepository;
	
	public void insererEnBase(List<Mesure> ListeDeMesures){
		ListeDeMesures.removeAll(Collections.singleton(null));
		mesureRepository.saveAll(ListeDeMesures);
	}

}
