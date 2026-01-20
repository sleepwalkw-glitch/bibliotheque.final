package com.example.demo.repository;

import com.example.demo.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre,Long> {


    //2.Livres disponibles :
    /* (1)by create a request in @Quiry for the database MySQL
    @Query("SELECT * FROM livre l WHERE l.exemplairesDisponibles > 0")
    List<Livre> getLivresDispoV1();
       (2)by using the method written in service layer which return to repository to call the method existing in JPA
     */

     //3.Searching by Categories
    /*
    //Version 1
    @Query("SELECT l.titre, l.auteur, l.categorie FROM livre l GROUP BY l.titre, l.auteur, l.categorie; ")
    List<Livre> findByCategorieV1();
    //version 2 : do not need to write in repository
     */
    //version3 for findByCategorie2 in livreController

}
