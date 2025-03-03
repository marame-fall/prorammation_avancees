package sn.uasz.m1.projet.gui;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.uasz.m1.projet.model.Utilisateur;
import java.util.Optional;

public class ResponsableDAO {
    private final EntityManagerFactory emf;

    public ResponsableDAO() {
        this.emf = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU");
    }

    public Optional<Utilisateur> findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :email", Utilisateur.class)
                    .setParameter("email", email)
                    .getResultStream()
                    .findFirst();
        } finally {
            em.close();
        }
    }
}
