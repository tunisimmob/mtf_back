package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.Contact;
import com.ingarch.promoteur.models.DevenezProprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@SuppressWarnings("unused")
@Repository
public interface DevenezProprietaireRepository extends JpaRepository<DevenezProprietaire, Long> {

    @Transactional
    DevenezProprietaire findTop1ByOrderByIdDesc();


}
