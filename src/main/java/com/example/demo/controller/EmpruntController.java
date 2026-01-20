package com.example.demo.controller;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    public EmpruntService empruntService;

//    @GetMapping("/all"){
//        public List<Emprunt> getAllEmprunts(){
//            return EmpruntService.getAllEmprunts();
//        }
//    }




}
