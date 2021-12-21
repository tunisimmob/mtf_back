package com.ingarch.promoteur.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Cache;


@Entity
@Table(name = "Projet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class Projet implements Serializable {


    @OneToMany(mappedBy = "projet")
    @JsonIgnore
    private List<Appartement> appartements;


    @OneToMany(mappedBy = "projet")
    @JsonIgnore
    @Column(name = "videoprojet")
    private List<Video> videos;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "gouvernorat")
    private String gouvernorat;

    @Column(name = "localite")
    private String localite;

    @Column(name = "surface")
    private Integer surface;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "situation_url")
    private String situation_url;

    @Column(name = "situation")
    private String situation;

    @Column(name = "residence_gardee")
    private boolean residence_gardee;

    @Column(name = "double_vitrage")
    private boolean double_vitrage;

    @Column(name = "michelaire_electrique")
    private boolean michelaire_electrique;

    @Column(name = "chauffage_central")
    private boolean chauffage_central;

    @Column(name = "climatiseur_preinstalle")
    private boolean climatiseur_preinstalle;

    @Column(name = "videophone")
    private boolean videophone;

    @NotNull
    @Column(name = "etat")
    private String etat;

    @Column(name = "images_exterieur")
    @ElementCollection
    List<String> images_exterieur;

    @Column(name = "images_interieur")
    @ElementCollection
    List<String> images_interieur;


    @Column(name = "image_de_couverture")
    private String image_de_couverture;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSituation_url() {
        return situation_url;
    }

    public void setSituation_url(String situation_url) {
        this.situation_url = situation_url;
    }

    public boolean isResidence_gardee() {
        return residence_gardee;
    }

    public void setResidence_gardee(boolean residence_gardee) {
        this.residence_gardee = residence_gardee;
    }

    public boolean isDouble_vitrage() {
        return double_vitrage;
    }

    public void setDouble_vitrage(boolean double_vitrage) {
        this.double_vitrage = double_vitrage;
    }

    public boolean isMichelaire_electrique() {
        return michelaire_electrique;
    }

    public void setMichelaire_electrique(boolean michelaire_electrique) {
        this.michelaire_electrique = michelaire_electrique;
    }

    public boolean isChauffage_central() {
        return chauffage_central;
    }

    public void setChauffage_central(boolean chauffage_central) {
        this.chauffage_central = chauffage_central;
    }

    public boolean isClimatiseur_preinstalle() {
        return climatiseur_preinstalle;
    }

    public void setClimatiseur_preinstalle(boolean climatiseur_preinstalle) {
        this.climatiseur_preinstalle = climatiseur_preinstalle;
    }

    public boolean isVideophone() {
        return videophone;
    }

    public void setVideophone(boolean videophone) {
        this.videophone = videophone;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<Appartement> getAppartements() {
        return appartements;
    }

    public void setAppartements(List<Appartement> appartements) {
        this.appartements = appartements;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public List<String> getImages_exterieur() {
        return images_exterieur;
    }

    public void setImages_exterieur(List<String> images_exterieur) {
        this.images_exterieur = images_exterieur;
    }

    public List<String> getImages_interieur() {
        return images_interieur;
    }

    public void setImages_interieur(List<String> images_interieur) {
        this.images_interieur = images_interieur;
    }

    public String getImage_de_couverture() {
        return image_de_couverture;
    }

    public void setImage_de_couverture(String image_de_couverture) {
        this.image_de_couverture = image_de_couverture;
    }


}