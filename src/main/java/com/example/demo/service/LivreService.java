package com.example.demo.service;

import com.example.demo.model.Livre;
import com.example.demo.repository.LivreRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service


public class LivreService {

    //    @Autowired
    public LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    // get livre by Id
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The book with id: " + id + " does not exist."));
    }

    //1. Liste complète
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    //2.Livres disponibles
    public List<Livre> getLivresDispoV2() {
        List<Livre> Relist = livreRepository.findAll();
        List<Livre> LivreDispo = new ArrayList<>();
        for (Livre l : Relist) {
            if (l.getExemplairesDisponibles() <= 0) {
                System.out.println("No exemplaire of this book is availble.");
            } else {
                LivreDispo.add(l);
            }
        }
        return LivreDispo;
    }

    //3.Recherche par catégorie
    public List<Livre> findByCategorieV3(String categorie) {
        List<Livre> Relist2 = livreRepository.findAll();
        List<Livre> LivreFindByCategorie2 = new ArrayList<>();

        for (Livre lvr: Relist2){
            if (lvr.getCategorie().equalsIgnoreCase(categorie)){
                LivreFindByCategorie2.add(lvr);
            }
        }
        return LivreFindByCategorie2;
    }
}




