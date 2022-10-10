package com.alaoui.evente.web;


import com.alaoui.evente.DAO.ClientRepository;
import com.alaoui.evente.DAO.CommandeRepository;
import com.alaoui.evente.DAO.LigneCommandeRepository;
import com.alaoui.evente.DAO.ProduitRepository;
import com.alaoui.evente.entities.Client;
import com.alaoui.evente.entities.Commande;
import com.alaoui.evente.entities.LigneCommande;
import com.alaoui.evente.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@CrossOrigin("*")
@RestController
public class CommandeController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeRepository orderRepository;
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @PostMapping("/orders")
    public Commande saveOrder(@RequestBody CommandeForm orderForm){
        Client client=new Client();
        client.setNomClient(orderForm.getClient().getNomClient());
        client.setEmail(orderForm.getClient().getEmail());
        client.setAdresse(orderForm.getClient().getAdresse());
        client.setTel(orderForm.getClient().getTel());
        client.setUsername(orderForm.getClient().getUsername());
        client=clientRepository.save(client);
        System.out.println(client.getIdClient());

        Commande commande=new Commande();
        commande.setClient(client);
        commande.setDateCommande(new Date());
        commande=orderRepository.save(commande);
        double total=0;
        for(CommandeProduit p:orderForm.getProduits()){
            LigneCommande ligneCommande=new LigneCommande();
            ligneCommande.setCommande(commande);
            Produit produit=produitRepository.findById(p.getId()).get();
            ligneCommande.setProduit(produit);
            ligneCommande.setPrix(produit.getPrixCurrent());
            ligneCommande.setQuantite(p.getQuantity());
            ligneCommandeRepository.save(ligneCommande);
            total+=p.getQuantity()*produit.getPrixCurrent();
        }
        commande.setTotalPrix(total);
        return orderRepository.save(commande);
    }

}
