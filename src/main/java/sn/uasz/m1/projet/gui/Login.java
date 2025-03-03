package sn.uasz.m1.projet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Login extends JFrame {
    
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public Login() {
        setTitle("Connexion au système");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);
        
        emailField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(emailField, gbc);
        
        JLabel passwordLabel = new JLabel("Mot de passe:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);
        
        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        
        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);
        
        gbc.gridx = 1;
        panel.add(cancelButton, gbc);
        
        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(email, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Connexion réussie !");
                    dispose(); // Ferme la fenêtre de connexion
                    openAuthentification(); // Ouvre la page d'authentification
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Email ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        cancelButton.addActionListener(e -> dispose());
    }
    
    public static boolean authenticate(String email, String password) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU").createEntityManager();
            Long count = (Long) em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :password")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            return count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    private void openAuthentification() {
        // Créez et affichez la page d'authentification ou une autre fenêtre ici
        JFrame authentificationFrame = new JFrame("Page d'authentification");
        authentificationFrame.setSize(500, 300);
        authentificationFrame.setLocationRelativeTo(null);
        authentificationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        authentificationFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
