package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.DevenezProprietaire;
import com.ingarch.promoteur.models.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@SuppressWarnings("unused")
@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long> {


    @Transactional
    Presentation findTop1ByOrderByIdDesc();

}
