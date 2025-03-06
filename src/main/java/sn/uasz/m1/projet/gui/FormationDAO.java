package sn.uasz.m1.projet.gui;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.uasz.m1.projet.model.Formation;

public class FormationDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU");
    
    public void ajouterFormation(Formation formation) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(formation);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    // Méthode pour lister les formations
    public List<Formation> getAllFormations() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT f FROM Formation f", Formation.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void modifierFormation(int id, String nom, String niveau) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierFormation'");
    }

    public void supprimerFormation(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerFormation'");
    }
}
