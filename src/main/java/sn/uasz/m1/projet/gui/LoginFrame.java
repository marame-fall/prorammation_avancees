package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import sn.uasz.m1.projet.model.Utilisateur;

/**
 * Fenêtre de connexion à l'application
 */
public class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    
    /**
     * Constructeur qui initialise l'interface de connexion
     */
    public LoginFrame() {
        setTitle("Connexion au système");
        setSize(400, 200);
        initComponents();
    }
    
    /**
     * Initialise les composants de l'interface graphique
     */
    private void initComponents() {
        // Création des composants
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Mot de passe:");
        
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        
        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");
        
        // Configuration du layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel();
        
        // Ajout des composants au panel du formulaire avec GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(emailLabel, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(emailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(passwordField, gbc);
        
        // Ajout des boutons au panel des boutons
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        
        // Configuration des bordures et marges
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Ajout des panels au panel principal
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Ajout du panel principal à la fenêtre
        setContentPane(mainPanel);
        
        // Configuration des actions des boutons
        loginButton.addActionListener(this::handleLogin);
        cancelButton.addActionListener(e -> System.exit(0));
        
        // Faire que le bouton login soit le bouton par défaut
        getRootPane().setDefaultButton(loginButton);
    }
    
    /**
     * Gère l'action de connexion
     * @param e L'événement d'action
     */
    private void handleLogin(ActionEvent e) {
        String email = emailField.getText();
        String motDePasse = new String(passwordField.getPassword());
        
        if (email.isEmpty() || motDePasse.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "Veuillez remplir tous les champs", 
                    "Erreur de saisie", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Tentative d'authentification
            Connexion connexion = Connexion.getInstance();
            EntityManager em = connexion.getEntityManager();
            
            TypedQuery<Utilisateur> query = em.createQuery(
                    "SELECT u FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :motDePasse", 
                    Utilisateur.class);
            query.setParameter("email", email);
            query.setParameter("motDePasse", motDePasse);
            
            try {
                Utilisateur utilisateur = query.getSingleResult();
                JOptionPane.showMessageDialog(this, 
                        "Bienvenue " + utilisateur.getPrenom() + " " + utilisateur.getNom() + "!", 
                        "Connexion réussie", 
                        JOptionPane.INFORMATION_MESSAGE);

                        new Authentification();
                
                // Ici, vous pourriez ouvrir la fenêtre principale de l'application
                // et fermer la fenêtre de connexion
                // MainFrame mainFrame = new MainFrame(utilisateur);
                // mainFrame.setVisible(true);
                // this.dispose();
                
            } catch (NoResultException ex) {
                JOptionPane.showMessageDialog(this, 
                        "Email ou mot de passe incorrect", 
                        "Erreur d'authentification", 
                        JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                    "Erreur lors de la connexion: " + ex.getMessage(), 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
