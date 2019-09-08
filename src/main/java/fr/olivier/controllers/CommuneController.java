package fr.olivier.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.olivier.entite.*;
import fr.olivier.service.CommuneService;
import fr.olivier.service.MesureService;
import fr.olivier.utils.ApiUtils;
import fr.olivier.utils.CommuneUtils;
import fr.olivier.utils.JsonManipulation;
@RestController
@RequestMapping("/communes")
public class CommuneController {

	@Autowired
	CommuneService communeService;
	@Autowired
	MesureService mesureService;
	
	@GetMapping
	public List<Commune> obtenirLaListeDesCommunes(){
		return communeService.obtenirLaListeDesCommunes();
	}
	
	@GetMapping("/insertion")
	public List<Commune> insererLaListeDesCommunes() throws Exception{
	JSONObject myResponse = ApiUtils.callApi(
			"https://public.opendatasoft.com/api/records/1.0/search/?dataset=openaq&rows=1500&sort=measurements_lastupdated&facet=location&facet=measurements_parameter&facet=measurements_sourcename&facet=measurements_lastupdated&geofilter.polygon=(46.29001987172955%2C-2.48291015625)%2C(48.25028349849022%2C-2.48291015625)%2C(48.25028349849022%2C1.2139892578125)%2C(46.29001987172955%2C1.2139892578125)%2C(46.29001987172955%2C-2.48291015625)");

	List<StationDeMesure> listeDeStationsDeMesure = JsonManipulation.obtenirLesStationDeMesures(myResponse);

	JSONObject myResponseCommunes = ApiUtils.callApiCommunes(
			"https://geo.api.gouv.fr/communes?codeRegion=52&fields=nom,code,codesPostaux,centre,codeRegion,population&format=json&geometry=centre");
	List<Commune> listeDesCommunes = new ArrayList<Commune>();
	listeDesCommunes = JsonManipulation.obtenirLesCommunes(myResponseCommunes);

	listeDesCommunes = CommuneUtils.obtenirLesStationsDeMesuresLesPlusProches(listeDesCommunes,
			listeDeStationsDeMesure);
	List<Mesure> listeDesMesures = new ArrayList<Mesure>();
	listeDesMesures=JsonManipulation.obtenirLesMesures(myResponse,listeDeStationsDeMesure);
	communeService.insererEnBas(listeDesCommunes);
	mesureService.insererEnBase(listeDesMesures);

	 return listeDesCommunes;
	}
}
