package com.example.produits.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entities.Categorie;
import com.example.produits.repos.CategoryRepository;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRestController {
	@Autowired
	CategoryRepository categoryRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Categorie> getAllCategories()
	{
	return categoryRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
	return categoryRepository.findById(id).get();
	}
	


}
