package com.alaoui.evente.web;

import com.alaoui.evente.entities.Client;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommandeForm {
    private Client client=new Client();
    private List<CommandeProduit> produits = new ArrayList<>();
}

@Data
class CommandeProduit{
    private Long id;
    private int quantity;

}