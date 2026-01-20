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

    //the method to get all members by using the method of JPA
    public List<Membre> getAllMembres() {
//        if the method is not declaired as static, it will be required to be called with an object instance,but not on the class name;
        return membreRepository.findAll();
    }

    // method to get the members active
    public List<Membre> findByActifTrue(){
        return membreRepository.findByActifTrue();
    }

    // method to get the members by its id
    public Optional<Membre> findMembreById(Long id){
        return membreRepository.findById(id);
    }

    // method to create the members
//    public Membre createMembre(Membre membre) {
////        membre.setNom( ); should we set the attributes?
//        return membreRepository.save(membre);
//    }



}
