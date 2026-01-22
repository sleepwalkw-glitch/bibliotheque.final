package com.example.demo.service;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.repository.LivreRepository;
import com.example.demo.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpruntService {

    @Autowired
    private final EmpruntRepository empruntRepository;
    private final LivreRepository livreRepository;
    private final MembreRepository membreRepository;


    public EmpruntService(EmpruntRepository empruntRepository, LivreRepository livreRepository, MembreRepository membreRepository) {
        this.empruntRepository = empruntRepository;
        this.livreRepository = livreRepository;
        this.membreRepository = membreRepository;
    }

    //0. Get un emprunt par id
    public Emprunt getEmpruntById(Long id) {
        return empruntRepository.getById(id);
    }


    // 1. Liste complète
    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    // 2. Emprunts en cours
    public List<Emprunt> getEmpruntEnCour() {
        //(1)first version: using JPQL of nativeQuery with @Query method in repository
        //        return empruntRepository.getEmpruntEnCour();

        //(2) second version: write a method to create a list with all the emprunts en cours reusing the method of JPA
        List<Emprunt> emprunts = empruntRepository.findAll();
        List<Emprunt> empruntEnCours = new ArrayList<>();

        for (Emprunt e : emprunts) {
            if (e.getDateRetourEffective() == null) {
                empruntEnCours.add(e);
            }
        }
        return empruntEnCours;
    }


    // 3. Emprunts en retard
    public List<Emprunt> getEmpruntEnRetard(LocalDate localDate) {
        //(1)first version: @Query in repository
//        return empruntRepository.getEmpruntEnRetard(localDate);
        //(2)second version: with JPA and method
        List<Emprunt> emprunts1 = empruntRepository.findAll();
        List<Emprunt> empruntEnRetard = new ArrayList<>();
        for(Emprunt e2: emprunts1){
            if(e2.getDateRetourEffective() != null && e2.getDateRetourPrevue().isBefore(localDate) ){
                empruntEnRetard.add(e2);
            }
        }
        return empruntEnRetard;
    }
    // 4. Emprunts d'un membre spécifique


    // 5. Emprunts d'un livre?


}
