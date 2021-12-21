package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@SuppressWarnings("unused")
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {


    @Transactional
    Integer countByEtat(String etat);


    @Transactional
    List<Projet> findProjetByEtatOrderById(String etat);

    Projet findProjetByEtat(String etat);

}
