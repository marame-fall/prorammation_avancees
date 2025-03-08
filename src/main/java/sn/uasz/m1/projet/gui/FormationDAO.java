package sn.uasz.m1.projet.gui;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import sn.uasz.m1.projet.model.Formation;
import sn.uasz.m1.projet.model.Responsable;
import sn.uasz.m1.projet.model.UE;

public class FormationDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU");
    
    public void ajouterFormation(Formation formation) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            // Récupérer le responsable par défaut (admin@uasz.sn)
            TypedQuery<Responsable> query = em.createQuery("SELECT r FROM Responsable r WHERE r.email = :email", Responsable.class);
            query.setParameter("email", "admin@uasz.sn");
            Responsable responsable = query.getSingleResult();
            
            formation.setResponsable(responsable);
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

    public List<Formation> getAllFormations() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT f FROM Formation f", Formation.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void supprimerFormation(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // Récupérer la formation à supprimer
            Formation formation = em.find(Formation.class, id);
            if (formation != null) {
                em.remove(formation); // Supprimer la formation
            }
            
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
    
    public void modifierFormation(Formation formation) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(formation); // Met à jour la formation dans la base de données
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

    public Formation getFormationById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Formation.class, id);
        } finally {
            em.close();
        }
    }

    public List<UE> getAllUes() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<UE> ues = null;
        try {
            ues = em.createQuery("SELECT u FROM UE u", UE.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return ues;
    }
    
    public void ajouterUe(UE ue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouterUe'");
    }

    public void modifierUe(UE ue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifierUe'");
    }

    public void supprimerUe(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerUe'");
    }
    
    
}
