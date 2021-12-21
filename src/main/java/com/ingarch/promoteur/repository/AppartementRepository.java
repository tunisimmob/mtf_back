package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@SuppressWarnings("unused")
@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {


    Appartement findTop1AppartementByNombrechambreAndProjetEtat(String nb, String etat);

    List<Appartement> findByNombrechambreAndProjetEtat(String nb, String etat);


}
