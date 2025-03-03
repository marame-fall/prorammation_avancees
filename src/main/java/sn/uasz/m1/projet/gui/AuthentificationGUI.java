package sn.uasz.m1.projet.gui;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AuthentificationGUI extends JFrame {
    public AuthentificationGUI() {
        setTitle("Choix du profil");
        setSize(500, 350); // Réduction de la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(240, 242, 245));

        // Création du panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre
        JLabel titleLabel = new JLabel("Bienvenue dans le menu Gestion Inscription Pédagogique");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Taille de police réduite
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0)); // Espacement horizontal de 20px
        buttonPanel.setBackground(Color.WHITE);
        
        // Bouton Étudiant
        JButton etudiantBtn = new JButton ("Étudiant");
        etudiantBtn.addActionListener(e -> new ConnResponsable());
        
        // Bouton Responsable
        JButton responsableBtn = new JButton ("Responsable");
        responsableBtn.addActionListener(e -> new ConnResponsable());
        
        buttonPanel.add(etudiantBtn);
        buttonPanel.add(responsableBtn);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        // Message d'instruction
        JLabel instructionLabel = new JLabel("Sélectionnez votre profil pour continuer");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Taille de police réduite
        instructionLabel.setForeground(new Color(95, 99, 104));
        gbc.gridy = 2;
        panel.add(instructionLabel, gbc);

        add(panel);
    }

    /*private JButton createRoleButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Taille de police réduite
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(140, 40)); // Dimensions réduites
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color.darker(), 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        
        // Effet hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.brighter());
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        button.addActionListener(e -> {
            if(text.equals("Étudiant")){
                new InscriptionEtudiant().setVisible((true));
            }
            else if (text.equals("Responsable")){
                new IdentificationResponsable().setVisible(true);
            }

            dispose();
            JOptionPane.showMessageDialog(this, "Connexion en tant que : " + text);
        });

        return button;
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthentificationGUI().setVisible(true));
    }
}