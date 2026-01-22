package com.example.demo.repository;

import com.example.demo.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {


    //2. Emprunts en cours: version one
//    @Query(value = "SELECT * FROM emprunt e WHERE e.date_retour_effective IS NULL;", nativeQuery = true ) syntax of nativeQuery .below is the code with JPQL way is correct
//    @Query("SELECT e FROM Emprunt e WHERE e.dateRetourEffective IS NULL")
//    List<Emprunt> getEmpruntEnCour();

    //3.Emprunts en retard :version one
    @Query("SELECT e FROM Emprunt e WHERE e.dateRetourEffective IS NULL AND e.dateRetourPrevue < :localDate")
    List<Emprunt> getEmpruntEnRetard(LocalDate localDate);

}
