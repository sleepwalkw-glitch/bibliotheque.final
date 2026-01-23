package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="livre")
public class Livre {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="titre")
    private String titre;

    @Column(name="auteur")
    private String auteur;

    @Column(name="isbn")
    private String isbn;

    @Column(name="annee_publication")
    private Integer anneePublication;

    @Column(name="categorie")
    private String categorie;

    @Column(name="exemplaires_total")
    private Integer exemplairesTotal;

    @Column(name = "exemplaires_disponibles")
    private Integer exemplairesDisponibles;

    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)
    @JsonManagedReference (value = "emprunt-livre")
    private List<Emprunt> emprunts;

    public Livre(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getExemplairesTotal() {
        return exemplairesTotal;
    }

    public void setExemplairesTotal(Integer exemplairesTotal) {
        this.exemplairesTotal = exemplairesTotal;
    }

    public Integer getExemplairesDisponibles() {
        return exemplairesDisponibles;
    }

    public void setExemplairesDisponibles(Integer exemplairesDisponibles) {
        this.exemplairesDisponibles = exemplairesDisponibles;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

}

