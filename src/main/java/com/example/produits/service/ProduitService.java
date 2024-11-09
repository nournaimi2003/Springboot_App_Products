package com.example.produits.service;

import java.util.List;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.entities.ProduitDTO;

public interface ProduitService {
	ProduitDTO saveProduit(ProduitDTO p);
	ProduitDTO updateProduit(ProduitDTO p);
	void deleteProduit(Produit p);
	 void deleteProduitById(Long id);
	 ProduitDTO  getProduit(Long id);
	List<ProduitDTO > getAllProduits();
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();
	List<Produit> findByCategorieIdCategorie(Long idCategorie);
    List<Categorie> getAllCategories();
	ProduitDTO convertEntityToDto (Produit produit);
	Produit convertDtoToEntity(ProduitDTO produitDto); 
	
}
