package com.alaoui.evente.web;



import com.alaoui.evente.DAO.ProduitRepository;
import com.alaoui.evente.entities.Produit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    private final ProduitRepository produitRepository;

    public CatalogueRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Produit p=produitRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/event/produits/"+p.getPhotoName()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Produit p=produitRepository.findById(id).get();
        p.setPhotoName(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/event/produits/"+p.getPhotoName()),file.getBytes());
        produitRepository.save(p);
    }
}
