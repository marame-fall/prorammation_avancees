/*package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AuthentificationGUI extends JFrame {

    public AuthentificationGUI() {
        setTitle("Choix du profil");
        setSize(2000, 1000); // Augmentation de la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(new Color(240, 242, 245)); // Couleur de fond

        // Titre
        JLabel titleLabel = new JLabel("Bienvenue dans le menu Gestion Inscription Pédagogique");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20)); // Police moderne
        titleLabel.setForeground(new Color(52, 73, 94));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 30, 0)); // Espacement horizontal de 30px
        buttonPanel.setOpaque(false); // Rend le panel transparent

        // Bouton Étudiant
        JButton etudiantBtn = createStyledButton("Étudiant", "/image/etu.jpeg");
        etudiantBtn.addActionListener(e -> new ConnResponsable());

        // Bouton Responsable
        JButton responsableBtn = createStyledButton("Responsable", "/image/res.jpeg");
        responsableBtn.addActionListener(e -> new ConnResponsable());

        buttonPanel.add(etudiantBtn);
        buttonPanel.add(responsableBtn);

        // Message d'instruction
        JLabel instructionLabel = new JLabel("Sélectionnez votre profil pour continuer");
        instructionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Police moderne
        instructionLabel.setForeground(new Color(95, 99, 104));
        instructionLabel.setHorizontalAlignment(JLabel.CENTER);

        // Ajout des composants à la fenêtre
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(instructionLabel, BorderLayout.SOUTH);

        // Vérification des chemins des images
        System.out.println("Chemin de l'icône étudiant : " + getClass().getResource("/image/etu.jpeg"));
        System.out.println("Chemin de l'icône responsable : " + getClass().getResource("/image/res.jpeg"));
    }

    private JButton createStyledButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        button.setFocusPainted(false);
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthentificationGUI().setVisible(true));
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
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AuthentificationGUI extends JFrame {
    
    // Couleurs différentes pour les deux panneaux
    private static final Color COULEUR_GAUCHE = new Color(18, 30, 60); // Bleu très foncé
    private static final Color COULEUR_DROITE = new Color(41, 58, 100); // Bleu nuit plus clair
    
    public AuthentificationGUI() {
        setTitle("Authentification - Gestion d'Inscription Pédagogique");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Création du panneau principal divisé en deux
        JPanel mainPanel = new JPanel(new GridBagLayout());
        
        // Panneau gauche pour l'image ou texte
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(COULEUR_GAUCHE);
        leftPanel.setPreferredSize(new Dimension(600, 700));
        
        // Au lieu d'utiliser une image qui pourrait ne pas exister,
        // utilisons directement un panneau avec du texte
        JLabel titleLeftLabel = new JLabel("Gestion Inscription Pédagogique");
        titleLeftLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLeftLabel.setForeground(Color.WHITE);
        titleLeftLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel descriptionLabel = new JLabel("Université Assane Seck de Ziguinchor");
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        descriptionLabel.setForeground(new Color(200, 200, 255));
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel textPanel = new JPanel(new GridBagLayout());
        textPanel.setBackground(COULEUR_GAUCHE);
        
        GridBagConstraints textGbc = new GridBagConstraints();
        textGbc.gridwidth = GridBagConstraints.REMAINDER;
        textGbc.insets = new Insets(10, 20, 10, 20);
        
        textGbc.gridy = 0;
        textPanel.add(titleLeftLabel, textGbc);
        
        textGbc.gridy = 1;
        textPanel.add(descriptionLabel, textGbc);
        
        leftPanel.add(textPanel, BorderLayout.CENTER);
        
        // Bordure pour le panneau gauche
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(255, 255, 255, 50)));
        
        // Panneau droit avec fond bleu plus clair
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(COULEUR_DROITE);
        
        // Titre
        JLabel titleLabel = new JLabel("Bienvenue");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Sous-titre
        JLabel subtitleLabel = new JLabel("Veuillez choisir votre profil");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitleLabel.setForeground(new Color(200, 200, 255));
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Bouton Étudiant
        JButton etudiantBtn = createStyledButton("Étudiant");
        etudiantBtn.addActionListener(e -> {
            dispose(); // Fermer cette fenêtre
            new ConnEtudiant(); // Ouvrir la connexion étudiant
        });
        
        // Bouton Responsable
        JButton responsableBtn = createStyledButton("Responsable");
        responsableBtn.addActionListener(e -> {
            dispose(); // Fermer cette fenêtre
            new ConnResponsable(); // Ouvrir la connexion responsable
        });
        
        // Ajout des composants au panneau droit avec GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 30, 10, 30);
        
        gbc.gridy = 0;
        rightPanel.add(titleLabel, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 30, 60, 30);
        rightPanel.add(subtitleLabel, gbc);
        
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 80, 30, 80);
        rightPanel.add(etudiantBtn, gbc);
        
        gbc.gridy = 3;
        rightPanel.add(responsableBtn, gbc);
        
        // Ajout des panneaux gauche et droit au panneau principal
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainGbc.weightx = 0.5;
        mainGbc.weighty = 1.0;
        mainGbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(leftPanel, mainGbc);
        
        mainGbc.gridx = 1;
        mainPanel.add(rightPanel, mainGbc);
        
        // Ajout du panneau principal à la fenêtre
        add(mainPanel);
        
        setVisible(true);
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(59, 89, 182)); // Bleu plus foncé pour les boutons
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        button.setFocusPainted(false);
        
        // Effet hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(79, 109, 202)); // Bleu plus clair au survol
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(59, 89, 182)); // Retour à la couleur normale
            }
        });
        
        return button;
    }
    
   
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthentificationGUI());
    }
}


    
  
        
       
    
   