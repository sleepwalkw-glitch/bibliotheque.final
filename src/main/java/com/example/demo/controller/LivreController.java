package com.example.demo.controller;

import com.example.demo.model.Livre;
import com.example.demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") //permission for the access of AJAX
@RequestMapping("/api/livres")
public class LivreController {

    @Autowired //injection of the service layer and initialisation
    public LivreService livreService;

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id){
        return livreService.getLivreById(id);
    }

    //1.Liste complète
    @GetMapping("/all")
    public List<Livre> getAllLivres(){
        return livreService.getAllLivres();
    }

    //2.Livres disponibles
    @GetMapping("/disponibles")
    public List<Livre> getLivresDispo(){
        //version 1 :request the database by @Query
        //   return livreService.getLivresDispoV1();
        //version 2: call the method in JPA .findAll(),then verify the condition before print the list
        return livreService.getLivresDispoV2();
    }

    //3.Recherche par catégorie
    @GetMapping("/categories/{categorie}")
    //version 1 and 2
  /*  public List<Livre> findByCategorie1(){
        //version 1: request the database by @Query
        //     return  livreService.findByCategorieV1();
        //version 2: call the method did not exist in JPA but created manuelle through verification
            return  livreService.findByCategorieV2();
    }

   */
    //version 3
    public List<Livre> findByCategorie2(@PathVariable String categorie) {
        if (categorie != null && !categorie.isEmpty()) {
            return (Livre) livreService.findByCategorieV3();


}
