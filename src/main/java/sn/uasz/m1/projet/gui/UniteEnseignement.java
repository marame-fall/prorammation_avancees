package sn.uasz.m1.projet.gui;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UniteEnseignement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ajout d'un identifiant unique auto-généré

    private String code;
    private String nom;
    private int volumeHoraire;
    private int coefficient;
    private int credits;
    private String enseignant;
    private boolean obligatoire;

    // 🔹 Constructeurs
    public UniteEnseignement() {
    }

    public UniteEnseignement(String code, String nom, int volumeHoraire, int coefficient, int credits, String enseignant) {
        this.code = code;
        this.nom = nom;
        this.volumeHoraire = volumeHoraire;
        this.coefficient = coefficient;
        this.credits = credits;
        this.enseignant = enseignant;
    }

    public boolean isObligatoire(){
        return obligatoire;
    }
    // 🔹 Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(int volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public void setObligatoire(boolean obligatoire) {
        this.obligatoire = obligatoire;
    }

    // 🔹 Méthode toString() pour affichage facile
    @Override
    public String toString() {
        return "UniteEnseignement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", volumeHoraire=" + volumeHoraire +
                ", coefficient=" + coefficient +
                ", credits=" + credits +
                ", enseignant='" + enseignant + '\'' +
                '}';
    }

}
