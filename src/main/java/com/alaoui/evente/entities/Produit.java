package com.alaoui.evente.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdProduit;
    private String name;
    private String Designation;
    private double PrixCurrent;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    @Transient
    private int quantity=1;
    @ManyToOne
    @JoinColumn(name = "IdCategorie")
    private Categorie categorie;


}
