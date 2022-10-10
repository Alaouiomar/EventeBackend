package com.alaoui.evente.DAO;

import com.alaoui.evente.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    @RestResource(path = "/selectedProducts")
    public List<Produit> findBySelectedIsTrue();
    @RestResource(path = "/productsByKeyword")
    public List<Produit> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/promoProducts")
    public List<Produit> findByPromotionIsTrue();
    @RestResource(path = "/dispoProducts")
    public List<Produit> findByAvailableIsTrue();
}
