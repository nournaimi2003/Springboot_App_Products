package com.example.produits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.entities.ProduitDTO;
import com.example.produits.repos.ProduitRepository;

@Service

public class ProduitServiceImpl implements ProduitService{
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		// TODO Auto-generated method stub
	
		return convertEntityToDto( produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		// TODO Auto-generated method stub
		return convertEntityToDto( produitRepository.save(convertDtoToEntity(p)));
			
	}
	@Override
	public void deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.delete(p);
	}

	@Override
	public void deleteProduitById(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
		
	}

	@Override
	public ProduitDTO getProduit(Long id) {
		// TODO Auto-generated method stub
		return convertEntityToDto(produitRepository.findById(id).get());
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());

	}

	public List<Produit> findByNomProduit(String nom) {
	return produitRepository.findByNomProduit(nom);
	}
	public List<Produit> findByNomProduitContains(String nom) {
	return produitRepository.findByNomProduitContains(nom);
	}
	public List<Produit> findByNomPrix(String nom, Double prix) {
	return produitRepository.findByNomPrix(nom, prix);
	}
	public List<Produit> findByCategorie(Categorie categorie) {
	return produitRepository.findByCategorie(categorie);
	}
	
	public List<Produit> findByOrderByNomProduitAsc() {
	return produitRepository.findByOrderByNomProduitAsc();
	}
	public List<Produit> trierProduitsNomsPrix() {
	return produitRepository.trierProduitsNomsPrix();
	}
	@Override
	public List<Produit> findByCategorieIdCategorie(Long idCategorie) {
		return produitRepository.findByCategorieIdCategorie(idCategorie);
		}

	
		@Autowired
		ModelMapper modelMapper;
		@Override
		public ProduitDTO convertEntityToDto(Produit produit) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);

		
		 return produitDTO; 
		 }
		@Override
		public Produit convertDtoToEntity(ProduitDTO produitDto) {
		Produit produit = new Produit();
		produit = modelMapper.map(produitDto, Produit.class);
		return produit;
		}
		/*return ProduitDTO.builder()
				.idProduit(produit.getIdProduit())
				.nomProduit(produit.getNomProduit())
				.prixProduit(produit.getPrixProduit())
				.dateCreation(produit.getDateCreation())
				.categorie(produit.getCategorie())
				.build();*/

		@Override
		public List<Categorie> getAllCategories() {
			// TODO Auto-generated method stub
			return null;
		}

	/*@Override
	public Produit convertDtoToEntity(ProduitDTO produitDto) {
		Produit produit = new Produit();
		produit.setIdProduit(produitDto.getIdProduit());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixProduit(produitDto.getPrixProduit());
		produit.setDateCreation(produitDto.getDateCreation());
		produit.setCategorie(produitDto.getCategorie()); 
		 return produit;    */            
	}

	


