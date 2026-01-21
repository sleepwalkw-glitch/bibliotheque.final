package com.example.demo.service;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.repository.LivreRepository;
import com.example.demo.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpruntService {


    private final EmpruntRepository empruntRepository;
    private final LivreRepository livreRepository;
    private final MembreRepository membreRepository;


    public EmpruntService(EmpruntRepository empruntRepository, LivreRepository livreRepository, MembreRepository membreRepository) {
        this.empruntRepository = empruntRepository;
        this.livreRepository = livreRepository;
        this.membreRepository = membreRepository;
    }

    // 0. Get un emprunt par id
//    public static Emprunt getEmpruntById(Long id) {
//
//    }

    // 1. Liste complète
//    public List<Emprunt> getAllEmprunts() {
//        return EmpruntRepository.findAll();
//    }

    // 2. Emprunts en cours
    // 3. Emprunts en retard
    // 4. Emprunts d'un membre spécifique

    // 5. Emprunts d'un livre?


}
