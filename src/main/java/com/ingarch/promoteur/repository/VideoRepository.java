package com.ingarch.promoteur.repository;
import com.ingarch.promoteur.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unused")
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {




}
