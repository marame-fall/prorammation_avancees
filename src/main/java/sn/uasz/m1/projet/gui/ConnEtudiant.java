/*package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ConnEtudiant extends JFrame {
    
    private final Color BACKGROUND_COLOR = Color.WHITE;
    private final Color GREEN_COLOR = new Color(60, 179, 113);
    private final Color TEXT_COLOR = new Color(70, 70, 70);
    private final Color SUBTITLE_COLOR = new Color(100, 100, 100);
    
    public ConnEtudiant() {
        setTitle("Espace Étudiant - Gestion des Inscriptions Pédagogiques");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panneau principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        
        // Barre s/*upérieure (header)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 40));
        
        JLabel titleLabel = new JLabel("Espace Étudiant - Gestion des Inscriptions Pédagogiques");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        datePanel.setBackground(Color.BLACK);
        JLabel dateLabel = new JLabel("4 mars 21:01");
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        datePanel.add(dateLabel);
        headerPanel.add(datePanel, BorderLayout.EAST);
        
        // Panneau de contenu principal
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);
        
        // Panneau gauche pour l'illustration
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(BACKGROUND_COLOR);
        leftPanel.setPreferredSize(new Dimension(500, 600));
        
        // Créer un libellé de placeholder pour l'image (normalement, on utiliserait getResource)
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Essayer de charger l'image, sinon mettre un texte descriptif
        try {
            // Utiliser File pour un chemin absolu si nécessaire
             ImageIcon illustration = new ImageIcon("/image/etu.jpeg");
            // En attendant, créer un panneau de couleur verte
            JPanel illustrationPanel = new JPanel();
            illustrationPanel.setPreferredSize(new Dimension(300, 400));
            illustrationPanel.setBackground(new Color(230, 250, 240));
            
            JLabel illustrationText = new JLabel("<html><div style='text-align: center;'>Illustration<br>Étudiant avec Téléphone</div></html>");
            illustrationText.setForeground(GREEN_COLOR);
            illustrationText.setFont(new Font("Segoe UI", Font.BOLD, 16));
            illustrationPanel.add(illustrationText);
            
            imageLabel.add(illustrationPanel);
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Illustration de connexion");
            errorLabel.setForeground(GREEN_COLOR);
            errorLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            imageLabel.add(errorLabel);
        }
        
        leftPanel.add(imageLabel, BorderLayout.CENTER);
        
        // Panneau droit pour le formulaire de connexion
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(BACKGROUND_COLOR);
        rightPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        // Titre du formulaire
        JLabel welcomeLabel = new JLabel("Bienvenue dans votre espace étudiant");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(TEXT_COLOR);
        
        // Sous-titre du formulaire
        JLabel infoLabel = new JLabel("Informations");
        infoLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        infoLabel.setForeground(SUBTITLE_COLOR);
        
        // Champ de texte pour l'email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(TEXT_COLOR);
        
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(300, 35));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        
        // Champ de mot de passe
        JLabel passwordLabel = new JLabel("Mot de Passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(TEXT_COLOR);
        
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(300, 35));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        
        // Option pour afficher le mot de passe
        JCheckBox showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        showPasswordCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        showPasswordCheckBox.setForeground(SUBTITLE_COLOR);
        showPasswordCheckBox.setBackground(BACKGROUND_COLOR);
        showPasswordCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });
        
        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(GREEN_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        
        // Effet hover sur le bouton
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(40, 160, 90));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(GREEN_COLOR);
            }
        });
        
        // Lien pour créer un compte
        JLabel noAccountLabel = new JLabel("Vous n'avez pas de compte ? Inscrivez-vous ici");
        noAccountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        noAccountLabel.setForeground(SUBTITLE_COLOR);
        noAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        noAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Ferme la fenêtre actuelle
                new InscriptionEtudiant(); // Ouvre la fenêtre d'inscription
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                noAccountLabel.setForeground(GREEN_COLOR); // Changement de couleur au survol
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                noAccountLabel.setForeground(SUBTITLE_COLOR);
            }
        });
        
        
        // Ajouter tous les composants au panneau droit
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.gridwidth = 2;
        
        // Titre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        rightPanel.add(welcomeLabel, gbc);
        
        // Sous-titre Informations
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 15, 0);
        rightPanel.add(infoLabel, gbc);
        
        // Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        rightPanel.add(emailLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        rightPanel.add(emailField, gbc);
        
        // Mot de passe
        gbc.gridx = 0;
        gbc.gridy = 4;
        rightPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        rightPanel.add(passwordField, gbc);
        
        // Checkbox afficher mot de passe
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(5, 0, 20, 0);
        rightPanel.add(showPasswordCheckBox, gbc);
        
        // Bouton connexion
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(loginButton, gbc);
        
        // Texte pas de compte
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 0, 0, 0);
        rightPanel.add(noAccountLabel, gbc);
        
        // Bouton retour (à gauche de la fenêtre)
        JButton returnButton = new JButton("return");
        returnButton.setBackground(Color.WHITE);
        returnButton.setForeground(TEXT_COLOR);
        returnButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        returnButton.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.setFocusPainted(false);
        returnButton.addActionListener(e -> {
            dispose();
            new AuthentificationGUI();
        });
        
        JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnPanel.setBackground(BACKGROUND_COLOR);
        returnPanel.add(returnButton);
        
        // Organiser les panneaux dans le panneau de contenu
        GridBagConstraints contentGbc = new GridBagConstraints();
        contentGbc.gridx = 0;
        contentGbc.gridy = 0;
        contentGbc.weightx = 0.5;
        contentGbc.weighty = 1.0;
        contentGbc.fill = GridBagConstraints.BOTH;
        contentPanel.add(leftPanel, contentGbc);
        
        contentGbc.gridx = 1;
        contentPanel.add(rightPanel, contentGbc);
        
        // Ajouter tous les panneaux au panneau principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(returnPanel, BorderLayout.SOUTH);
        
        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);
        
        // Rendre la fenêtre visible
        setVisible(true);
    }
    
    // Méthode main pour tester indépendamment
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConnEtudiant());
    }
}*/

package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ConnEtudiant extends JFrame {
    
    private final Color BACKGROUND_COLOR = Color.WHITE;
    private final Color GREEN_COLOR = new Color(60, 179, 113);
    private final Color TEXT_COLOR = new Color(70, 70, 70);
    private final Color SUBTITLE_COLOR = new Color(100, 100, 100);
    
    public ConnEtudiant() {
        setTitle("Espace Étudiant - Gestion des Inscriptions Pédagogiques");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panneau principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        
        // Barre supérieure (header)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLACK);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 40));
        
        JLabel titleLabel = new JLabel("Espace Étudiant - Gestion des Inscriptions Pédagogiques");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setBorder(new EmptyBorder(0, 15, 0, 0));
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        //JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //datePanel.setBackground(Color.BLACK);
        //JLabel dateLabel = new JLabel("4 mars 21:01");
        //dateLabel.setForeground(Color.WHITE);
        //dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        //datePanel.add(dateLabel);
        //headerPanel.add(datePanel, BorderLayout.EAST);
        
        // Panneau de contenu principal
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);
        
        // Panneau gauche pour l'illustration
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(BACKGROUND_COLOR);
        leftPanel.setPreferredSize(new Dimension(500, 600));
        
        // Charger l'image depuis le classpath (vérification si le fichier existe)
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        try {
            // Utiliser getResource pour charger l'image dans le classpath
            ImageIcon illustration = new ImageIcon(getClass().getResource("/image/etu.jpeg"));
            
            // Vérifier si l'image a bien été trouvée
            if (illustration.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
                throw new Exception("Image non trouvée !");
            }
            
            imageLabel.setIcon(illustration);
        } catch (Exception e) {
            // Afficher un message d'erreur si l'image n'a pas pu être chargée
            JLabel errorLabel = new JLabel("Illustration de connexion non trouvée");
            errorLabel.setForeground(GREEN_COLOR);
            errorLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
            imageLabel.add(errorLabel);
        }
        
        leftPanel.add(imageLabel, BorderLayout.CENTER);
        
        // Panneau droit pour le formulaire de connexion
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(BACKGROUND_COLOR);
        rightPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        // Titre du formulaire
        JLabel welcomeLabel = new JLabel("Bienvenue dans votre espace étudiant");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(TEXT_COLOR);
        
        // Sous-titre du formulaire
        JLabel infoLabel = new JLabel("Informations");
        infoLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        infoLabel.setForeground(SUBTITLE_COLOR);
        
        // Champ de texte pour l'email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setForeground(TEXT_COLOR);
        
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(300, 35));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        
        // Champ de mot de passe
        JLabel passwordLabel = new JLabel("Mot de Passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setForeground(TEXT_COLOR);
        
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(300, 35));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        
        // Option pour afficher le mot de passe
        JCheckBox showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        showPasswordCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        showPasswordCheckBox.setForeground(SUBTITLE_COLOR);
        showPasswordCheckBox.setBackground(BACKGROUND_COLOR);
        showPasswordCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });
        
        // Bouton de connexion
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(GREEN_COLOR);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        
        // Effet hover sur le bouton
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(40, 160, 90));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(GREEN_COLOR);
            }
        });
        
        // Lien pour créer un compte
        JLabel noAccountLabel = new JLabel("Vous n'avez pas de compte ? Inscrivez-vous ici");
        noAccountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        noAccountLabel.setForeground(SUBTITLE_COLOR);
        noAccountLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        noAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Ferme la fenêtre actuelle
                new InscriptionEtudiant(); // Ouvre la fenêtre d'inscription
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                noAccountLabel.setForeground(GREEN_COLOR); // Changement de couleur au survol
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                noAccountLabel.setForeground(SUBTITLE_COLOR);
            }
        });
        
        // Ajouter tous les composants au panneau droit
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.gridwidth = 2;
        
        // Titre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        rightPanel.add(welcomeLabel, gbc);
        
        // Sous-titre Informations
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 15, 0);
        rightPanel.add(infoLabel, gbc);
        
        // Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        rightPanel.add(emailLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        rightPanel.add(emailField, gbc);
        
        // Mot de passe
        gbc.gridx = 0;
        gbc.gridy = 4;
        rightPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        rightPanel.add(passwordField, gbc);
        
        // Checkbox afficher mot de passe
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(5, 0, 20, 0);
        rightPanel.add(showPasswordCheckBox, gbc);
        
        // Bouton connexion
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(loginButton, gbc);
        
        // Texte pas de compte
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 0, 0, 0);
        rightPanel.add(noAccountLabel, gbc);
        
        // Organiser les panneaux dans le panneau de contenu
        GridBagConstraints contentGbc = new GridBagConstraints();
        contentGbc.gridx = 0;
        contentGbc.gridy = 0;
        contentGbc.weightx = 0.5;
        contentGbc.weighty = 1.0;
        contentGbc.fill = GridBagConstraints.BOTH;
        contentPanel.add(leftPanel, contentGbc);
        
        contentGbc.gridx = 1;
        contentPanel.add(rightPanel, contentGbc);
        
        // Ajouter tous les panneaux au panneau principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);
        
        // Rendre la fenêtre visible
        setVisible(true);
    }
    
    // Méthode main pour tester indépendamment
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConnEtudiant());
    }
}
