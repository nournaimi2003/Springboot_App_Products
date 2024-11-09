package com.example.produits.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entities.Produit;
import com.example.produits.entities.ProduitDTO;
import com.example.produits.service.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRestController {
	@Autowired 
	ProduitService produitService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ProduitDTO> getAllProduits()
	{
		return produitService.getAllProduits();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	
	public ProduitDTO getProduitById(@PathVariable("id") Long id) {
	return produitService.getProduit(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO) {
	return produitService.saveProduit(produitDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
	produitService.deleteProduitById(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public ProduitDTO updateProduit(@RequestBody ProduitDTO produitDTO) {
	return produitService.updateProduit(produitDTO);
	}
	
	@RequestMapping(value="/prodscat/{idCategorie}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCategorie") Long idCategorie) {
	return produitService.findByCategorieIdCategorie(idCategorie);
	}

	




}
