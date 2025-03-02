package sn.uasz.m1.projet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import jakarta.persistence.EntityManager;
import sn.uasz.m1.projet.gui.Connexion;
import sn.uasz.m1.projet.gui.LoginFrame;

/**
 * Classe principale de l'application
 */
public class App {
    public static void main(String[] args) {
        try {
            // Définir le look-and-feel du système
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Tester la connexion à la base de données
            Connexion connexion = null;
            try {
                connexion = Connexion.getInstance();
                EntityManager em = connexion.getEntityManager();
                
                if (em != null && em.isOpen()) {
                    System.out.println("Connexion à la base de données réussie.");
                    
                    // Lancer l'interface graphique
                    SwingUtilities.invokeLater(() -> {
                        // Créer et afficher la fenêtre de connexion
                        LoginFrame loginFrame = new LoginFrame();
                        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        loginFrame.setLocationRelativeTo(null); // Centrer la fenêtre
                        loginFrame.setVisible(true);
                    });
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Impossible de se connecter à la base de données.", 
                            "Erreur de connexion", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.err.println("Erreur lors de l'initialisation de la connexion : " + e.getMessage());
                JOptionPane.showMessageDialog(null, 
                        "Erreur de connexion à la base de données : " + e.getMessage(), 
                        "Erreur", 
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors du lancement de l'application : " + e.getMessage());
            e.printStackTrace();
        }
    }
}