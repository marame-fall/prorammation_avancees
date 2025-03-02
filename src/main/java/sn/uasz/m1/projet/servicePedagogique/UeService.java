package sn.uasz.m1.projet.servicePedagogique;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sn.uasz.m1.projet.model.UE;

public class UeService {

    private final EntityManagerFactory emf;

    public UeService() {
        this.emf = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU");
    }

    public void creerUe(UE ue) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(ue);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}