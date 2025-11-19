package com.gestion_produits.gestion_produits.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Produits")
@Getter
@Setter
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(unique = true)
    private String nomProduit;

    @Basic(optional = false)
    private String description;

    @Basic(optional = false)
    private String reference;

    @Basic(optional = false)
    private String type;

}
