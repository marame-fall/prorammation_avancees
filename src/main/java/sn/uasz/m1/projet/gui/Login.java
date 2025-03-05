package sn.uasz.m1.projet.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Login extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public Login() {
        setTitle("Connexion au système");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Utilise ImagePanel comme fond
        ImagePanel backgroundPanel = new ImagePanel("/image/ath.jpeg");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Augmente les marges

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Nouvelle police
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(emailLabel, gbc);

        emailField = new JTextField(30);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Nouvelle police
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Nouvelle police
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(30);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Nouvelle police
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(passwordField, gbc);

        loginButton = new JButton("Se connecter");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton = new JButton("Annuler");
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Définir une taille fixe pour les boutons
        Dimension buttonSize = new Dimension(150, 30); // Ajuste ces valeurs selon tes besoins
        loginButton.setPreferredSize(buttonSize);
        cancelButton.setPreferredSize(buttonSize);

        // Bouton "Se connecter"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Occupe 1 colonne
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(loginButton, gbc);

        // Bouton "Annuler"
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Occupe 1 colonne
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(cancelButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(email, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Connexion réussie !");
                    dispose(); // Ferme la fenêtre de connexion
                    new AuthentificationGUI().setVisible(true); // Ouvre la page d'authentification
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Email ou mot de passe incorrect.", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(e -> dispose());
        setSize(500, 200);
        // setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximise la fenêtre
    }

    public static boolean authenticate(String email, String password) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU").createEntityManager();
            Long count = (Long) em.createQuery(
                    "SELECT COUNT(u) FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :password")
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }

    // Classe ImagePanel pour l'image de fond
    static class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(String imagePath) {
            try {
                URL imgUrl = getClass().getResource(imagePath);
                if (imgUrl != null) {
                    image = ImageIO.read(imgUrl);
                } else {
                    System.err.println("Image not found: " + imagePath);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}
        

/* 

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Login extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public Login() {
        setTitle("Connexion au système");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Utilise ImagePanel comme fond
        ImagePanel backgroundPanel = new ImagePanel("/image/ath.jpeg");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Augmente les marges

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(emailLabel, gbc);

        emailField = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(30);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(passwordField, gbc);

        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");

        // Bouton "Se connecter"
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Occupe 1 colonne
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(loginButton, gbc);

        // Bouton "Annuler"
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Occupe 1 colonne
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplir horizontalement
        backgroundPanel.add(cancelButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticate(email, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Connexion réussie !");
                    dispose(); // Ferme la fenêtre de connexion
                    new AuthentificationGUI().setVisible(true); // Ouvre la page d'authentification
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Email ou mot de passe incorrect.", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(e -> dispose());
        setSize(500,200);
       // setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximise la fenêtre
    }

    public static boolean authenticate(String email, String password) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU").createEntityManager();
            Long count = (Long) em.createQuery(
                    "SELECT COUNT(u) FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :password")
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }

    // Classe ImagePanel pour l'image de fond
    static class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(String imagePath) {
            try {
                URL imgUrl = getClass().getResource(imagePath);
                if (imgUrl != null) {
                    image = ImageIO.read(imgUrl);
                } else {
                    System.err.println("Image not found: " + imagePath);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}*/