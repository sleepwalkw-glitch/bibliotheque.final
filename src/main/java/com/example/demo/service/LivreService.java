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

    // get livre by Id with optional throw out
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The book with id: " + id + " does not exist."));

    }

    //1. Liste complète
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    //2.Livres disponibles
        /*(1) first way : by calling the method written in repository with @Query() to verifying the database MySQL
    public List<Livre> getLivresDispoV1() {
        return livreRepository.getLivresDispoV1();
    }
         */

    //(2)second way : by executing the method in service layer written
    public List<Livre> getLivresDispoV2() {
        //(1) check if the attribute(exemplaire_disponible) of the type of Integer, for an object livre, is it more than 0
        List<Livre> Relist = livreRepository.findAll();
        List<Livre> LivreDispo = new ArrayList<>();
        // to irritate the livre and checking for the condition of exemplaire more than 0
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
    /*(1)version 1: by calling the method written in repository which is to use @Query to request directly the database MySQL
    public List<Livre> findByCategorieV1() {
         return livreRepository.findByCategorieV1();
        }

     */

    /*
    //(2)version 2: by checking if the catégorie input is already exist in the database, if so, print the list , else pop alter information
    public List<Livre> findByCategorieV2() {
    // step 1: create a method to get a book by its categorie // step 2: compare the info of input with the list of categorie
    // 1.first way: to compare the input value with the categories existing in database
    Scanner categorieSC = new Scanner(System.in);
    List<Livre> Relist1 = livreRepository.findAll();
    List<Livre> LivreFindByCategorie = new ArrayList<>();

        for(Livre l: Relist1){
            if (l.getCategorie().equalsIgnoreCase(categorieSC.next())){
                LivreFindByCategorie.add(l);
            }else{
                throw new IllegalArgumentException("Input Categorie :" + categorieSC + "does not exist!");
            }
        }
        return LivreFindByCategorie;

        }

     */
        //2.second way: to find the book by categorie by using method does not exist in JPA but with @Pathvariable
    public List<Livre> findByCategorieV3() {
        List<Livre> Relist2 = livreRepository.findAll();
        String[] categoriesExisting = {"Classique","Cuisine", "Fantasy", "Histoire","Informatique","Philosophie","Roman","Science","Science-fiction", "Stratégie"};
        List<Livre> LivreFindByCategorie2 = new ArrayList<>();

        for (Livre lvr: Relist2){
            if (lvr.getCategorie().equalsIgnoreCase())
        }
        return livreRepository.findByCategorieV3();
    }
}




