package com.example.demo.service;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

//    public List<Emprunt> getAllEmprunts() {
//        return EmpruntRepository.findAll();
//    }


}
