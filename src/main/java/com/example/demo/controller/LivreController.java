package com.example.demo.controller;

import com.example.demo.model.Livre;
import com.example.demo.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/livres")
public class LivreController {

    @Autowired
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
        return livreService.getLivresDispoV2();
    }


    //3.Recherche par catégorie
    @GetMapping("/categories/{categorie}")
    public List<Livre> findByCategorie2(@PathVariable String categorie) {
        if (categorie == null || categorie.isEmpty()) {
            throw new IllegalArgumentException("Categorie can not be null or empty!");
        }
        else {
            return livreService.findByCategorieV3(categorie);
        }
    }


    }



