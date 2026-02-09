package com.example.demo.controller;

import com.example.demo.model.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import com.example.demo.service.EmpruntService;
import com.example.demo.service.LivreService;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    public EmpruntService empruntService;
    public LivreService livreService;
    public MembreService membreService;

    // 0. Get un emprunt par id
    @GetMapping("/{id}")
    public Emprunt getEmpruntById(@PathVariable Long id){
        return empruntService.getEmpruntById(id);
    }

    // 1. Liste complète
    @GetMapping("/all")
    public List<Emprunt> getAllEmprunts(){
            return empruntService.getAllEmprunts();
        }


    // 2. Emprunts en cours
    @GetMapping("/encours")
    public List<Emprunt> getEmpruntEnCour(){
        return empruntService.getEmpruntEnCour();
    }

    // 3. Emprunts en retard
    @GetMapping("/enRetard")
    public List<Emprunt> getEmpruntEnRetard(){

        return empruntService.getEmpruntEnRetard();
    }

    // 4. Emprunts d'un membre spécifique

    @GetMapping("/getEmprunt/{idMembre}")
    public  List<Emprunt> getEmpruntMem(@PathVariable Long idMembre){
        return empruntService.getEmpruntMem(getEmpruntById(idMembre));
    }

    //  5. Emprunts d'un livre
    @GetMapping("/getEmprunt/{idLivre}")
    public  List<Emprunt> getEmpruntLivre(@PathVariable Long idLivre){
        return empruntService.getEmpruntLivre(getEmpruntById(idLivre));
    }

    /* Optional 6.Create new borrow for member and for book:  create an emprunt by updating the info for livre and for member as well as the emprunt
   @PostMapping
   public Emprunt createEmprunt(@RequestBody Map<String, String> body){
       Long idLivre =Long.parseLong(body.get("idlivre"));
       Long idMembre = Long.parseLong(body.get("idMembre"));
       LocalDate dateRetourPrevue = LocalDate.parse(body.get("dateRetourPrevue"));

       return  empruntService.createEmprunt(idLivre,idMembre,dateRetourPrevue);
   }
   */
    }
