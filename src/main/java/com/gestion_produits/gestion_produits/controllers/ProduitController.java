package com.gestion_produits.gestion_produits.controllers;


import com.gestion_produits.gestion_produits.entities.Produit;
import com.gestion_produits.gestion_produits.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/produits")
@Tag(name = "Produits", description = "API de gestion des produits")
public class ProduitController {

    private ProduitService  produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Operation(
            summary = "Créer un nouveau produit",
            description = "Permet de créer un nouveau produit dans la base de données"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Produit créé avec succès"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Données invalides"
            )
    })

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@Parameter(description = "Données du produit à créer", required = true)
                           @RequestBody Produit produit){
        this.produitService.create(produit);
    }
    @Operation(
            summary = "Récupérer tous les produits",
            description = "Retourne la liste complète de tous les produits"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Liste des produits récupérée avec succès",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Produit.class)
                    )
            )
    })

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Produit> search(){
        return this.produitService.search();
    }

    @Operation(
            summary = "Récupérer un produit par son ID",
            description = "Retourne un produit spécifique en fonction de son identifiant"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Produit trouvé",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Produit.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produit non trouvé"
            )
    })

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Produit searchById( @Parameter(description = "ID du produit à récupérer", required = true, example = "1")
                                   @PathVariable Long id){

        return this.produitService.searchById(id);
    }

    @Operation(
            summary = "Supprimer un produit",
            description = "Supprime un produit de la base de données en fonction de son ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Produit supprimé avec succès"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produit non trouvé"
            )
    })

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    public void delete(@Parameter(description = "ID du produit à supprimer", required = true, example = "1")
                           @PathVariable Long id){

        this.produitService.delete(id);
    }

    @Operation(
            summary = "Mettre à jour un produit",
            description = "Met à jour les informations d'un produit existant"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Produit mis à jour avec succès"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produit non trouvé"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Données invalides"
            )
    })

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@Parameter(description = "ID du produit à mettre à jour", required = true, example = "1")
                           @PathVariable Long id,
                       @Parameter(description = "Nouvelles données du produit", required = true)
                       @RequestBody Produit produit){

        this.produitService.update(id, produit);
    }
}

