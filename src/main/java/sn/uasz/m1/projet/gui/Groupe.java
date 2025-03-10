package sn.uasz.m1.projet.gui;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Groupe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private int tailleMax;

    public Groupe() {
    }

    public Groupe(String nom, String type, int tailleMax) {
        this.nom = nom;
        this.type = type;
        this.tailleMax = tailleMax;
    }

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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getTailleMax() {
        return tailleMax;
    }
    public void setTailleMax(int tailleMax) {
        this.tailleMax = tailleMax;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", tailleMax=" + tailleMax +
                '}';
    }
}
