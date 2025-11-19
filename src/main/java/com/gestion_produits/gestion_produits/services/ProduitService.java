package com.gestion_produits.gestion_produits.services;

import com.gestion_produits.gestion_produits.entities.Produit;
import com.gestion_produits.gestion_produits.repositories.ProduitRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProduitService {

    private ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public void create(Produit produit){

        this.produitRepository.save(produit);
    }

    public List<Produit> search(){

        return this.produitRepository.findAll();
    }

    public Produit searchById(Long id){
        Optional<Produit> optionalProduit = this.produitRepository.findById(id);
        if(optionalProduit.isPresent()){
            return optionalProduit.get();
        }
        return null;
    }

    public void delete(Long id) {

        this.produitRepository.deleteById(id);
    }

    public void update(Long id, Produit produit){
        Optional<Produit> optionalProduit = this.produitRepository.findById(id);
        if(optionalProduit.isPresent()){
            Produit modif = optionalProduit.get();

            modif.setNomProduit(produit.getNomProduit());
            modif.setDescription(produit.getDescription());
            modif.setReference(produit.getReference());
            modif.setType(produit.getType());

            this.produitRepository.save(modif);
        }

    }
}
