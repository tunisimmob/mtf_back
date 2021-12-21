package com.ingarch.promoteur.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Presentation")
public class Presentation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "titre")
    private String titre;


    @Column(name = "description")
    @Lob
    private String description;


    @Column(name = "image1")
    private String image1;


    @Column(name = "image2")
    private String image2;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }
}