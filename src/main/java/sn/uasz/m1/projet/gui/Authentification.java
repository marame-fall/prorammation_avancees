/*package sn.uasz.m1.projet.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentification extends JFrame {

    public Authentification() {
        setTitle("PAGE D'AUTHENTIFICATION");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Utilisation de BorderLayout pour organiser les composants

        // Bouton Déconnexion (Nord-Est)
        JButton deconnexionButton = new JButton("Déconnexion");
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Panneau pour aligner le bouton à droite
        northPanel.add(deconnexionButton);
        add(northPanel, BorderLayout.NORTH);

        // Panneau central pour les boutons Étudiant et Responsable
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // GridLayout pour organiser les boutons
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100)); // Marge autour des boutons

        JButton etudiantButton = new JButton("Étudiant");
        JButton responsableButton = new JButton("Responsable");

        centerPanel.add(etudiantButton);
        centerPanel.add(responsableButton);

        add(centerPanel, BorderLayout.CENTER);

        // Actions des boutons
        etudiantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre de connexion pour étudiant
                new LoginFrame().setVisible(true);
                dispose(); // Fermer la fenêtre d'authentification
            }
        });

        responsableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre de connexion pour responsable
                new LoginFrame().setVisible(true);
                dispose(); // Fermer la fenêtre d'authentification
            }
        });

        deconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implémenter la logique de déconnexion (si nécessaire)
                System.exit(0); // Fermer l'application
            }
        });

        setVisible(true);
    }

   // public static void main(String[] args) {
      //  new Authentification();
   // }
}*/

package sn.uasz.m1.projet.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentification extends JFrame {

    public Authentification() {
        setTitle("PAGE D'AUTHENTIFICATION");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Bouton Déconnexion (Nord-Est)
        JButton deconnexionButton = new JButton("Déconnexion");
        deconnexionButton.setBackground(Color.LIGHT_GRAY); // Couleur de fond
        deconnexionButton.setForeground(Color.DARK_GRAY); // Couleur du texte
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        northPanel.add(deconnexionButton);
        add(northPanel, BorderLayout.NORTH);

        // Panneau central pour les boutons Étudiant et Responsable
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 20, 20)); // Espacement entre les boutons
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        // Bouton Étudiant avec image
        ImageIcon etudiantIcon = new ImageIcon("images/etudiant.png"); // Chemin de l'image
        JButton etudiantButton = new JButton("Étudiant", etudiantIcon);
        etudiantButton.setHorizontalTextPosition(JButton.CENTER);
        etudiantButton.setVerticalTextPosition(JButton.BOTTOM);
        etudiantButton.setBackground(new Color(220, 220, 220)); // Couleur de fond plus claire

        // Bouton Responsable avec image
        ImageIcon responsableIcon = new ImageIcon("images/responsable.png"); // Chemin de l'image
        JButton responsableButton = new JButton("Responsable", responsableIcon);
        responsableButton.setHorizontalTextPosition(JButton.CENTER);
        responsableButton.setVerticalTextPosition(JButton.BOTTOM);
        responsableButton.setBackground(new Color(220, 220, 220));

        centerPanel.add(etudiantButton);
        centerPanel.add(responsableButton);

        add(centerPanel, BorderLayout.CENTER);

        // Actions des boutons
        etudiantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });

        responsableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });

        deconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    //public static void main(String[] args) {
       // new Authentification();
    //}
}