package com.example.demo.controller;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.service.EmpruntService;
import com.example.demo.service.LivreService;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/{id}")
//    public Emprunt getEmpruntById(@PathVariable Long id){
//        return EmpruntService.getEmpruntById(id);
//    }




    // 1. Liste complète

//    @GetMapping("/all")
//    public List<Emprunt> getAllEmprunts(){
//            return EmpruntService.getAllEmprunts();
//        }
//

    // 2. Emprunts en cours
    // 3. Emprunts en retard
    // 4. Emprunts d'un membre spécifique

    // 5. Emprunts d'un livre?



}
