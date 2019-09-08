package fr.olivier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.olivier.entites.Exemple;



public interface ExempleRepository  extends JpaRepository<Exemple, String> {

}
