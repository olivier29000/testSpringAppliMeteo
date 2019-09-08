package fr.olivier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.olivier.entite.Mesure;

public interface MesureRepository extends JpaRepository<Mesure, String>{

}
