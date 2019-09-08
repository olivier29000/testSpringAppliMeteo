package fr.olivier.utils;

import java.util.List;

import fr.olivier.entite.Commune;
import fr.olivier.entite.StationDeMesure;


public class CommuneUtils {
	
	
	public static List<Commune> obtenirLesStationsDeMesuresLesPlusProches(List<Commune> listeDesCommunes,List<StationDeMesure> listeDeStationsDeMesure){

		

			for (Commune commune : listeDesCommunes) {
				int idStationDeMesureLaPlusProche;
				double distanceStationDeMesureLaPlusProche = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheSO2 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProchePM25 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProchePM10 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheO3 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheNO2 = Double.MAX_VALUE;
				double distanceStationDeMesureLaPlusProcheCO = Double.MAX_VALUE;
				
				
				for (StationDeMesure stationDeMesure : listeDeStationsDeMesure) {
					double distancecalculee;
					distancecalculee = Math.sqrt(Math.pow(
							stationDeMesure.getPositionGps().getLatitude() - commune.getCentre().getLatitude(), 2)
							+ Math.pow(stationDeMesure.getPositionGps().getLongitude()
									- commune.getCentre().getLongitude(), 2));
					if (distancecalculee < distanceStationDeMesureLaPlusProche) {
						distanceStationDeMesureLaPlusProche = distancecalculee;
						commune.setDistance((int) (distancecalculee * 111110));
						commune.setStationDeMesure(stationDeMesure);
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheSO2 && stationDeMesure.getMesureSO2()==1) {
						distanceStationDeMesureLaPlusProcheSO2 = distancecalculee;
						commune.setDistanceSO2((int) (distancecalculee * 111110));
						commune.setStationDeMesureSO2(stationDeMesure);
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProchePM25 && stationDeMesure.getMesurePM25()==1) {
						distanceStationDeMesureLaPlusProchePM25 = distancecalculee;
						commune.setDistancePM25((int) (distancecalculee * 111110));
						commune.setStationDeMesurePM25(stationDeMesure);
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProchePM10 && stationDeMesure.getMesurePM10()==1) {
						distanceStationDeMesureLaPlusProchePM10 = distancecalculee;
						commune.setDistancePM10((int) (distancecalculee * 111110));
						commune.setStationDeMesurePM10(stationDeMesure);
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheO3 && stationDeMesure.getMesureO3()==1) {
						distanceStationDeMesureLaPlusProcheO3 = distancecalculee;
						commune.setDistanceO3((int) (distancecalculee * 111110));
						commune.setStationDeMesureO3(stationDeMesure);
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheNO2 && stationDeMesure.getMesureNO2()==1) {
						distanceStationDeMesureLaPlusProcheNO2 = distancecalculee;
						commune.setDistanceNO2((int) (distancecalculee * 111110));
						commune.setStationDeMesureNO2(stationDeMesure);
					}
					if (distancecalculee < distanceStationDeMesureLaPlusProcheCO && stationDeMesure.getMesureCO()==1) {
						distanceStationDeMesureLaPlusProcheCO = distancecalculee;
						commune.setDistanceCO((int) (distancecalculee * 111110));
						commune.setStationDeMesureCO(stationDeMesure);
					}
				}
				
				
				
				
				

				
			}
			
			
			return listeDesCommunes;
		}

}
