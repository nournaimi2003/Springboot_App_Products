package com.example.produits;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("PC Iphone",2500.000,new Date());
	produitRepository.save(prod);
	}
	
	public void testFindProduit()
	{
	Produit p = produitRepository.findById(1L).get(); 
	System.out.println(p);
	}
	public  void romoveProduit() {
	
		produitRepository.deleteById(2L);
		
	}
	public void updateProduit() {
		Produit p = produitRepository.findById(2L).get(); 
		p.setPrixProduit(100.000);
		produitRepository.save(p);
		
	}
	@Test
	public void testListerTousProduits()
	{
	List<Produit> prods = produitRepository.findAll();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomProduit()
	{
	List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomProduitContains()
	{
	List<Produit> prods = produitRepository.findByNomProduitContains("l");
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("PC", 1000.0);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByCategorie()
	 {
		Categorie cat = new Categorie();
		cat.setIdCategorie(1L);			
		List<Produit>  prods = produitRepository.findByCategorie(cat);
			for (Produit p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
	
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByOrderByPrixProduitDesc()
	{
	List<Produit> prods = produitRepository.findByOrderByPrixProduitDesc();
	
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByCategorieIdCat()
	{
	List<Produit> prods = produitRepository.findByCategorieIdCategorie(1L);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	 }

	


	 
	

}
