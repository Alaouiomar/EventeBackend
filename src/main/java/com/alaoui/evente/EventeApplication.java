package com.alaoui.evente;

import com.alaoui.evente.DAO.CategoryRepository;
import com.alaoui.evente.DAO.ProduitRepository;
import com.alaoui.evente.entities.Categorie;
import com.alaoui.evente.entities.Produit;
import com.alaoui.evente.entities.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class EventeApplication implements CommandLineRunner {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;


    public static void main(String[] args) {
        SpringApplication.run(EventeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        repositoryRestConfiguration.exposeIdsFor(Produit.class, Categorie.class);

        categoryRepository.save(new Categorie(null,"Sac-à-main",null,null,null));
        categoryRepository.save(new Categorie(null,"pull",null,null,null));
        Random rnd=new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i <10 ; i++) {
                Produit p=new Produit();
                p.setName(RandomString.make(18));
                p.setPrixCurrent(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategorie(c);
                p.setPhotoName("unknown.png");
                produitRepository.save(p);
            }
        });
    }


}
