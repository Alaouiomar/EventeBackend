package com.alaoui.evente.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdClient;
    private String NomClient;
    private String Adresse;
    private String email;
    private String tel;
    private String username;
    @OneToMany(mappedBy = "client")
    private Collection<Commande> commandes;


}
