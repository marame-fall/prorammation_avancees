/*package sn.uasz.m1.projet.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Login extends JFrame {
    private final Color BACKGROUND_COLOR = Color.WHITE;
    private final Color GREEN_COLOR = new Color(60, 179, 113);
    private final Color TEXT_COLOR = new Color(70, 70, 70);
    private final Color SUBTITLE_COLOR = new Color(100, 100, 100);

    public Login() {
        setTitle("Connexion au système");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 40));

        JLabel titleLabel = new JLabel("Page de connexion");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(BACKGROUND_COLOR);
        leftPanel.setPreferredSize(new Dimension(500, 600));
        JLabel imageLabel = new JLabel(new ImageIcon("/image/etu.jpeg"));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(BACKGROUND_COLOR);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel welcomeLabel = new JLabel("Bienvenue");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(TEXT_COLOR);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(TEXT_COLOR);
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(300, 35));

        JLabel passwordLabel = new JLabel("Mot de Passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(TEXT_COLOR);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(300, 35));

        JCheckBox showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        showPasswordCheckBox.setBackground(BACKGROUND_COLOR);
        showPasswordCheckBox.addActionListener(e -> passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '•'));

        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(GREEN_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticate(email, password)) {
                JOptionPane.showMessageDialog(this, "Connexion réussie !");
                dispose();
                new AuthentificationGUI().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Email ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton returnButton = new JButton("Annuler");
        returnButton.setBackground(Color.WHITE);
        returnButton.setForeground(TEXT_COLOR);
        returnButton.addActionListener(e -> {
            dispose();
            new AuthentificationGUI().setVisible(true);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.gridwidth = 2;

        gbc.gridx = 0; gbc.gridy = 0; rightPanel.add(welcomeLabel, gbc);
        gbc.gridy = 1; rightPanel.add(emailLabel, gbc);
        gbc.gridy = 2; rightPanel.add(emailField, gbc);
        gbc.gridy = 3; rightPanel.add(passwordLabel, gbc);
        gbc.gridy = 4; rightPanel.add(passwordField, gbc);
        gbc.gridy = 5; rightPanel.add(showPasswordCheckBox, gbc);
        gbc.gridy = 6; gbc.anchor = GridBagConstraints.CENTER; rightPanel.add(loginButton, gbc);
        gbc.gridy = 7; rightPanel.add(returnButton, gbc);

        contentPanel.add(leftPanel, new GridBagConstraints());
        contentPanel.add(rightPanel, new GridBagConstraints());

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static boolean authenticate(String email, String password) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU").createEntityManager();
            Long count = em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :password", Long.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
            return count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (em != null) em.close();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}*/
package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
    private final Color BACKGROUND_COLOR = Color.WHITE;
    private final Color GREEN_COLOR = new Color(60, 179, 113);
    private final Color TEXT_COLOR = new Color(70, 70, 70);

    public Login() {
        setTitle("Connexion au système");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Barre d'en-tête
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 40));

        JLabel titleLabel = new JLabel("Page de connexion");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);

        // Panel gauche (Image)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(BACKGROUND_COLOR);
        leftPanel.setPreferredSize(new Dimension(500, 600));

        // Chargement sécurisé de l'image
        JLabel imageLabel = loadImage("/image/vv.jpeg", 400, 400);
        if (imageLabel != null) {
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            leftPanel.add(imageLabel, BorderLayout.CENTER);
        }

        // Panel droit (Formulaire)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(BACKGROUND_COLOR);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel welcomeLabel = new JLabel("Connexion a la Base de Donnee");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(TEXT_COLOR);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(TEXT_COLOR);
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(300, 35));

        JLabel passwordLabel = new JLabel("Mot de Passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(TEXT_COLOR);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(300, 35));

        JCheckBox showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        showPasswordCheckBox.setBackground(BACKGROUND_COLOR);
        showPasswordCheckBox.addActionListener(e -> passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '•'));

        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(GREEN_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticate(email, password)) {
                JOptionPane.showMessageDialog(this, "Connexion réussie !");
                dispose();
                new AuthentificationGUI().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Email ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton returnButton = new JButton("Annuler");
        returnButton.setBackground(Color.WHITE);
        returnButton.setForeground(TEXT_COLOR);
        returnButton.addActionListener(e -> {
            dispose();
            new AuthentificationGUI().setVisible(true);
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.gridwidth = 2;

        gbc.gridx = 0; gbc.gridy = 0; rightPanel.add(welcomeLabel, gbc);
        gbc.gridy = 1; rightPanel.add(emailLabel, gbc);
        gbc.gridy = 2; rightPanel.add(emailField, gbc);
        gbc.gridy = 3; rightPanel.add(passwordLabel, gbc);
        gbc.gridy = 4; rightPanel.add(passwordField, gbc);
        gbc.gridy = 5; rightPanel.add(showPasswordCheckBox, gbc);
        gbc.gridy = 6; gbc.anchor = GridBagConstraints.CENTER; rightPanel.add(loginButton, gbc);
        gbc.gridy = 7; rightPanel.add(returnButton, gbc);

        contentPanel.add(leftPanel, new GridBagConstraints());
        contentPanel.add(rightPanel, new GridBagConstraints());

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    // ✅ Méthode de chargement sécurisé de l'image
    private JLabel loadImage(String path, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            if (icon.getIconWidth() == -1) {
                System.out.println("❌ Image non trouvée : " + path);
                return null;
            }
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(img));
        } catch (Exception e) {
            System.out.println("❌ Erreur de chargement de l'image : " + path);
            return null;
        }
    }

    // ✅ Méthode d'authentification avec JPA
    public static boolean authenticate(String email, String password) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("gestion_inscription_pedagogiquePU").createEntityManager();
            Long count = em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.email = :email AND u.motDePasse = :password", Long.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
            return count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (em != null) em.close();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}

