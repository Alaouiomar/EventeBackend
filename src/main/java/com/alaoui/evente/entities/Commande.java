package com.alaoui.evente.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "Commande")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCommande;
    private Date DateCommande;
    @OneToMany
    private Collection<LigneCommande> items;
    @ManyToOne
    @JoinColumn(name = "IdClient")
    private Client client;
    private double totalPrix;
    @OneToOne
    private Payement payement;

}
