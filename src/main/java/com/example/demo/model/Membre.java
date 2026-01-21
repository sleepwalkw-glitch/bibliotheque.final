package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="membre")
public class Membre {
    @Id
    @GeneratedValue
    private Long id;

    @Column (name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="email")
    private String email;

    @Column(name="telephone")
    private String telephone;

    @Column(name="date_inscription")
            // here in Mysql and in java they should be written differently
     private LocalDate dateInscription;

    @Column(name="actif")
    private boolean actif;

    //here the relationship for HashMap, the primery key is managed by membre and there are two foreign keys, one for livre and another for emprunt
    @OneToMany(mappedBy = "membre",cascade = CascadeType.ALL)
    @JsonManagedReference // this annotation is for the format of JSON to be shown correctly in API, in the charger of the map with primary key,should be followed with @JsonManagedReference, and for the side of foreigner key, should follow with another annotation @JsonBackReference,or not, they won't be got correctly in the foreigner key side
    // for the service layer, it should be able to create method for List all the emprunt
    private List<Emprunt> emprunts;

//constructor default
    public Membre() {}

//getter and setter
    public Membre(Long id, String nom, String prenom, String email, String telephone, LocalDate dateInscription, boolean actif, List<Emprunt> emprunts) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateInscription = dateInscription;
        this.actif = actif;
        this.emprunts = emprunts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}






