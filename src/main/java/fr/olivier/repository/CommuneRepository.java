package fr.olivier.repository;

import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.olivier.entite.Commune;

public interface CommuneRepository extends JpaRepository<Commune, String>{

}
