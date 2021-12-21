package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {




}
