package com.example.demo.controller;

import com.example.demo.model.Membre;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/membres")
public class MembreController {

    @Autowired
    public MembreService membreService;

    //1. to get all the information of the members existing
    @GetMapping("/all")
    public List<Membre> getAllMembres() {
        return membreService.getAllMembres();
    }

    //2. to get the info about the members active
    @GetMapping("/actif")
    public List<Membre> findByActifTrue() {
        return membreService.findByActifTrue();
    }

    //3. to find the member by its id
    @GetMapping("/{id}")
    public Optional<Membre> findMembreById(@PathVariable Long id) {
        return membreService.findMembreById(id);
    }

    /*
    //Optional work 4. create a member
    @PostMapping
    public Membre createMembre(@RequestBody Membre membre){
        return membreService.createMembre(membre);
    }

     //  Optional work 5.
    @PostMapping("/list")
    public List<Membre> addMembres(
            @RequestBody List<Membre> membres) {
        return membreService.addMembres(membres);
    }

    // Optional work 6. method to update a member or several members:

     */



}
