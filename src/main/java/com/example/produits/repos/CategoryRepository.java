package com.example.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.produits.entities.Categorie;


@RepositoryRestResource(path = "cat")
@CrossOrigin(origins = "http://localhost:4200/") //pour autoriser angular 
public interface CategoryRepository extends JpaRepository<Categorie, Long>{
	

}

