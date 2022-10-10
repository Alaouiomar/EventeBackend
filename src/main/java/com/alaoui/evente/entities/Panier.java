package com.alaoui.evente.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
    private Map<Long,LigneCommande> items= new HashMap<Long,LigneCommande>();


    public void addArticle(Produit p, int Quantite){
        if(items.get(p.getIdProduit())==null){
            LigneCommande lc = new LigneCommande();
            lc.setProduit(p);
            lc.setQuantite(Quantite);
            lc.setPrix(p.getPrixCurrent());
        }
        else{
            LigneCommande lc = items.get(p.getIdProduit());
            lc.setQuantite(lc.getQuantite()+Quantite);
        }
    }

    public Collection<LigneCommande> getItems(){
        return  items.values();
    }

    public double getTotal(){
        double total =0;
        for (LigneCommande lc:items.values()){
            total+=lc.getPrix()*lc.getQuantite();
        }
        return total;
    }

    public int getSize(){
       return items.size();
    }

    public void deleteItem(Long idProduit){
        items.remove(idProduit);
    }
}
