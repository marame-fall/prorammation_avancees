package sn.uasz.m1.projet.servicePedagogique;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sn.uasz.m1.projet.model.Formation;
import sn.uasz.m1.projet.model.UE;

public class FormationService {
    private final EntityManagerFactory emf;

    public FormationService() {
        this.emf = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU");
    }

    public void creerFormation(Formation formation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(formation);
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

    public Formation getFormationById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Formation.class, id);
        } finally {
            em.close();
        }
    }

    public void mettreAJourFormation(Formation formation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(formation);
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

    public void supprimerFormation(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Formation formation = em.find(Formation.class, id);
            if (formation != null) {
                em.remove(formation);
            }
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

    public void ajouterUeAFormation(Long formationId, List<UE> ues) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Formation formation = em.find(Formation.class, formationId);
            if (formation != null) {
                List<UE> uesExistantes = formation.getUes();
                for (UE ue : ues) {
                    ue.setFormation(formation);
                }
                uesExistantes.addAll(ues);
                formation.setUes(uesExistantes);
                em.merge(formation);
            }
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

    public void mettreAJourUeDeFormation(Long formationId, UE ue) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Formation formation = em.find(Formation.class, formationId);
            if (formation != null) {
                List<UE> uesExistantes = formation.getUes();
                for (int i = 0; i < uesExistantes.size(); i++) {
                    if (uesExistantes.get(i).getId().equals(ue.getId())) {
                        ue.setFormation(formation);
                        uesExistantes.set(i, ue);
                        formation.setUes(uesExistantes);
                        em.merge(formation);
                        transaction.commit();
                        return;
                    }
                }
                System.out.println("UE introuvable dans la formation");
            } else {
                System.out.println("Formation introuvable");
            }
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

    public void retirerUeDeFormation(Long formationId, Long ueId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Formation formation = em.find(Formation.class, formationId);
            if (formation != null) {
                List<UE> uesExistantes = formation.getUes();
                uesExistantes.removeIf(ue -> ue.getId().equals(ueId));
                formation.setUes(uesExistantes);
                em.merge(formation);
            }
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
