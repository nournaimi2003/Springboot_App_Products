package com.example.produits.entities;

	
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Produit.class })
public interface projectionprod {
	
	public String getNomProduit();


}
