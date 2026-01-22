package com.example.demo.controller;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.service.EmpruntService;
import com.example.demo.service.LivreService;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    public EmpruntService empruntService;
    public LivreService livreService;
    public MembreService membreService;

    // 0. Get un emprunt par id
    @GetMapping("/{id}")
    public Emprunt getEmpruntById(@PathVariable Long id){
        return empruntService.getEmpruntById(id);
    }

    // 1. Liste complète
    @GetMapping("/all")
    public List<Emprunt> getAllEmprunts(){
            return empruntService.getAllEmprunts();
        }


    // 2. Emprunts en cours
    @GetMapping("/encours")
    public List<Emprunt> getEmpruntEnCour(){
        return empruntService.getEmpruntEnCour();
    }

    // 3. Emprunts en retard
    @GetMapping("/enRetard")
    public List<Emprunt> getEmpruntEnRetard(LocalDate localDate){
        //(1)first version: @Query in repository  //(2)second version: with JPA and method
        return empruntService.getEmpruntEnRetard(localDate);


    }

    // 4. Emprunts d'un membre spécifique

    // 5. Emprunts d'un livre?



}
