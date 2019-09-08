package fr.olivier.utils;

import java.util.List;

import fr.olivier.entite.Mesure;
import fr.olivier.entite.StationDeMesure;

public abstract class MesureUtils {
	
	public static StationDeMesure obtenirStationDeMesureCorrespondante(double latitude, double longitude, List<StationDeMesure> listeDeStationsDeMesures){
		
		for (StationDeMesure stationDeMesure : listeDeStationsDeMesures) {
			if(stationDeMesure.getLatitude()==latitude && stationDeMesure.getLongitude()==longitude){
				return stationDeMesure;
				
			}
		}
		return null;
		
	}

}
