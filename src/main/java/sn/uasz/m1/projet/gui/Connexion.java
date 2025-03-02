package sn.uasz.m1.projet.gui;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe singleton qui gère la connexion à la base de données via JPA
 */
public class Connexion {
    private static Connexion instance;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    /**
     * Constructeur privé qui initialise la connexion à la base de données
     */
    private Connexion() {
        try {
            // Création de l'EntityManagerFactory avec le nom de l'unité de persistance
            emf = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU");
            // Création de l'EntityManager
            em = emf.createEntityManager();
            System.out.println("Connexion à la base de données établie avec succès");
        } catch (Exception e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Méthode pour obtenir l'instance unique de la classe Connexion (Singleton)
     * @return l'instance de Connexion
     */
    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }
    
    /**
     * Méthode pour obtenir l'EntityManager
     * @return l'EntityManager
     */
    public EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Méthode pour fermer les ressources de connexion
     */
    public void fermerConnexion() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        System.out.println("Connexion à la base de données fermée");
    }
    
    /**
     * Méthode pour démarrer une transaction
     */
    public void demarrerTransaction() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }
    
    /**
     * Méthode pour valider une transaction
     */
    public void validerTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }
    
    /**
     * Méthode pour annuler une transaction
     */
    public void annulerTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}