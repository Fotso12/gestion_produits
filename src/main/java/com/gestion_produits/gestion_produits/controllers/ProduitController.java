package com.gestion_produits.gestion_produits.controllers;


import com.gestion_produits.gestion_produits.entities.Produit;
import com.gestion_produits.gestion_produits.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/produit")
public class ProduitController {

    private ProduitService  produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Produit produit){
        this.produitService.create(produit);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Produit> search(){
        return this.produitService.search();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Produit searchById(@PathVariable Long id){

        return this.produitService.searchById(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){

        this.produitService.delete(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable Long id, @RequestBody Produit produit){

        this.produitService.update(id, produit);
    }
}

