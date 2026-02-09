package com.example.demo.service;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.repository.LivreRepository;
import com.example.demo.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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
    public List<Emprunt> getEmpruntEnRetard() {
        return empruntRepository.getEmpruntEnRetard(LocalDate.now());
    }

    // 4. Emprunts d'un membre spécifique :
        public List<Emprunt> getEmpruntMem(Emprunt empruntById){
           List<Emprunt> emprunts2 = empruntRepository.findAll();
           List<Emprunt> empruntMem = new ArrayList<>();
           for(Emprunt e3:emprunts2){
               if(e3.getId() == empruntById.getId()){
                   empruntMem.add(e3);
               }
           }
           return empruntMem;
    }


    // 5. Emprunts d'un livre

    public List<Emprunt> getEmpruntLivre(Emprunt empruntById) {
        //(2)second version
        List<Emprunt> emprunts3 = empruntRepository.findAll();
        List<Emprunt> empruntLivre = new ArrayList<>();

        for(Emprunt e4: emprunts3){
            if (e4.getId() == empruntById.getId()){
                empruntLivre.add(e4);
            }
        }
        return empruntLivre;
    }

    /* Optional 6.Create new borrow for member and for book:
   public Emprunt createEmprunt(Long idLivre, Long idMembre, LocalDate dateRetourPrevue) {
       Livre livre = livreRepository.findById(idLivre)
               .orElseThrow(()->new IllegalArgumentException("Book not found."));

       if (livre.getExemplairesDisponibles() <= 0)
           throw new IllegalArgumentException("No example has been found.");

       Emprunt e = new Emprunt();
       e.setLivre(livre);
       e.setMembre(membreRepository.findById(idMembre).get());
       e.getDateEmprunt(LocalDate.now());
//        e.getDateRetourPrevue(dateRetourPrevue); to work on
       e.getDateRetourEffective(null);

       livre.setExemplairesDisponibles(livre.getExemplairesDisponibles());
       livreRepository.save(livre);

       return empruntRepository.save(e);

   }
   */


}
