package com.ingarch.promoteur.models;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "Appartement")
public class Appartement implements Serializable {

    @ManyToOne
    private Projet projet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "numero_dappartement")
    private Integer numerodappartement;


    @Column(name = "nombre_chambre")
    private String nombrechambre;


    @Column(name = "etage")
    private String etage;

    @Column(name = "nom_bloc")
    private String nombloc;

    @Column(name = "surface_totale")
    private Integer surfacetotale;

    @Column(name = "terrasse")
    private Integer terrasse;

    @Column(name = "surface_hors_oeuvre")
    private Integer surfacehorsoeuvre;


    @Column(name = "surface_commune")
    private Integer surfacecommune;


    @Column(name = "plan")
    private String plan;


    @Column(name = "emplacement")
    private String emplacement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Integer getNumerodappartement() {
        return numerodappartement;
    }

    public void setNumerodappartement(Integer numerodappartement) {
        this.numerodappartement = numerodappartement;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getNombloc() {
        return nombloc;
    }

    public void setNombloc(String nombloc) {
        this.nombloc = nombloc;
    }

    public Integer getSurfacetotale() {
        return surfacetotale;
    }

    public void setSurfacetotale(Integer surfacetotale) {
        this.surfacetotale = surfacetotale;
    }

    public Integer getSurfacehorsoeuvre() {
        return surfacehorsoeuvre;
    }

    public void setSurfacehorsoeuvre(Integer surfacehorsoeuvre) {
        this.surfacehorsoeuvre = surfacehorsoeuvre;
    }

    public Integer getSurfacecommune() {
        return surfacecommune;
    }

    public void setSurfacecommune(Integer surfacecommune) {
        this.surfacecommune = surfacecommune;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getNombrechambre() {
        return nombrechambre;
    }

    public void setNombrechambre(String nombrechambre) {
        this.nombrechambre = nombrechambre;
    }

    public Integer getTerrasse() {
        return terrasse;
    }

    public void setTerrasse(Integer terrasse) {
        this.terrasse = terrasse;
    }
}