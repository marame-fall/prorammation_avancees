package sn.uasz.m1.projet.gui;

import javax.swing.*;

public class InscriptionEtudiant extends JFrame {
    public InscriptionEtudiant() {
        setTitle("Inscription Étudiant");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Page d'inscription des étudiants", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
    
}

