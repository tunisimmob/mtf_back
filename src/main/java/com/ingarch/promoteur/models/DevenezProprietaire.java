package com.ingarch.promoteur.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "DevenezProprietaire")
public class DevenezProprietaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "titre_1")
    private String titre_1;

    @NotNull
    @Lob
    @Column(name = "texte_1")
    private String texte_1;

    @NotNull
    @Column(name = "titre_2")
    private String titre_2;

    @NotNull
    @Lob
    @Column(name = "texte_2")
    private String texte_2;

    @NotNull
    @Column(name = "image1")
    private String image1;

    @NotNull
    @Column(name = "image2")
    private String image2;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre_1() {
        return titre_1;
    }

    public void setTitre_1(String titre_1) {
        this.titre_1 = titre_1;
    }

    public String getTexte_1() {
        return texte_1;
    }

    public void setTexte_1(String texte_1) {
        this.texte_1 = texte_1;
    }

    public String getTitre_2() {
        return titre_2;
    }

    public void setTitre_2(String titre_2) {
        this.titre_2 = titre_2;
    }

    public String getTexte_2() {
        return texte_2;
    }

    public void setTexte_2(String texte_2) {
        this.texte_2 = texte_2;
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