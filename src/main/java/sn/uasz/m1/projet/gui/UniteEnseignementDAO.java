package sn.uasz.m1.projet.gui;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UniteEnseignementDAO {

    // Nom de l'unité de persistence définie dans ton fichier persistence.xml
    private static final String PERSISTENCE_UNIT_NAME = "gestion_inscription_pedagogiquePU";
    private EntityManagerFactory emf;

    public UniteEnseignementDAO() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void ajouterUniteEnseignement(UniteEnseignement ue) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ue);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
