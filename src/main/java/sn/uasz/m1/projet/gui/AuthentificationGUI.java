package sn.uasz.m1.projet.gui;

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
}