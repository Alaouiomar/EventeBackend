package com.alaoui.evente.DAO;

import com.alaoui.evente.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

}
