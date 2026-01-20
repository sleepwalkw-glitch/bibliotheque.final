package com.example.demo.controller;

import com.example.demo.model.Membre;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//for the permission of capable of being accessible by the request of AJAX
@CrossOrigin(origins = "*")
@RequestMapping("/api/membres")
public class MembreController {

    // for injection of the service layer but not the repository and then there will be no need for constructor where will initialise the object so the method in service and JPA can be reached
    @Autowired
    public  MembreService membreService;

    // to get all the information of the members existing
    @GetMapping("/all")
    public List<Membre> getAllMembres(){
        return membreService.getAllMembres();
    }

    //to get the info about the members active
    @GetMapping("/actif")
    public List<Membre> findByActifTrue(){
        return membreService.findByActifTrue();
    }

    //to find the member by its id
    @GetMapping("/{id}")
    public Optional<Membre> findMembreById(@PathVariable Long id){
        return membreService.findMembreById(id);
    }

    //method to create
    @PostMapping
    public Membre createMembre(@RequestBody Membre membre){
        return membreService.createMembre(membre);
    }







}
