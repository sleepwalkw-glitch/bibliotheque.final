package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
//annotation for JPA and for database MySQL
@Entity
@Table(name="emprunt")
public class Emprunt {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="date_emprunt")
    private LocalDate dateEmprunt;

    @Column(name = "date_retour_prevue")
    private LocalDate dateRetourPrevue;

    @Column(name = "date_retour_effective")
    private LocalDate dateRetourEffective;

    // relationship for map and foreign key, and the foreign key used here to find an object in map
    @ManyToOne
    @JoinColumn(name="membre_id")
    private Membre membre;
    //relationship for map and foreign key , in the same Entity, there can be several JoinColumn to provide the foreign key
    @ManyToOne
    @JoinColumn(name="livre_id")
    private Livre livre;

// constructor default
    public Emprunt(){}

//getter and setter
    public Emprunt(Long id, LocalDate dateEmprunt, LocalDate dateRetourPrevue, LocalDate dateRetourEffective, Membre membre, Livre livre) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourEffective = dateRetourEffective;
        this.membre = membre;
        this.livre = livre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(LocalDate dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public LocalDate getDateRetourEffective() {
        return dateRetourEffective;
    }

    public void setDateRetourEffective(LocalDate dateRetourEffective) {
        this.dateRetourEffective = dateRetourEffective;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
