package com.alaoui.evente.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "LigneCommandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LigneCommande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "IdProduit")
    private Produit produit;
    private int Quantite;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "IdCommande")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;



}
