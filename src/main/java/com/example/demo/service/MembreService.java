package com.example.demo.service;

import com.example.demo.model.Membre;
import com.example.demo.repository.MembreRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MembreService {
    private final MembreRepository membreRepository;

    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    //1. the method to get all members
    public List<Membre> getAllMembres() {
       return membreRepository.findAll();
    }

    // 2. method to get the members active
    public List<Membre> findByActifTrue(){
        return membreRepository.findByActifTrue();
    }

    //3.  method to get the members by its id
    public Optional<Membre> findMembreById(Long id){
        //here can use Optional or without Optional , and should check if the id is already exist in the database.
        return Optional.of(membreRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Member with the id" + id + "not found.")));
    }


    /*
    //Optional work 4. method to create a member
    public Membre createMembre(Membre membre) {
       return membreRepository.save(membre);
    }
     */

    /*
   //  Optional work 5. method to create members
      public List<Membre> addMembres(List<Membre> membres) {
        return membreRepository.saveAll(membres);
}

    // Optional work 6. method to update member:



     */


}
