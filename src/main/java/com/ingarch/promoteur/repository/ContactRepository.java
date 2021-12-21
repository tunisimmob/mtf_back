package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@SuppressWarnings("unused")
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {


    @Transactional
    Contact findTop1ByOrderByIdDesc();

}
