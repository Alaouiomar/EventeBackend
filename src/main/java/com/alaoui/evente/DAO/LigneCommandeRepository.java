package com.alaoui.evente.DAO;

import com.alaoui.evente.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
