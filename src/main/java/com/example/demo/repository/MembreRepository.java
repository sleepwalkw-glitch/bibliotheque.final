package com.example.demo.repository;

import com.example.demo.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRepository extends JpaRepository<Membre,Long> {
    //method to find the member active,as it could not get by the method exiting in JPA, it should be written in Repository before be called
    List<Membre> findByActifTrue();

//    public membre findByNom(String,nom); 1.the method written by developper

//    2.use the query to send the request for database MySQL,
//    3.or else we can just use the methods exist already in JPA like findById... and no need to rewritten in repository
//    @Query()
//    public Livre findMostPopularBook();
//
//    @Query("SELECT* FROM livres WHERE examplaireDisponible>0")
//    public  List<Livre> findAvecPlusDe0();
}
