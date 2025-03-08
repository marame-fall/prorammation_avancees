package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConnEtudiant extends JFrame {

    public ConnEtudiant() {
        setTitle("Connexion Étudiant");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal avec fond blanc
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label titre
        

        setVisible(true);
    }

   public static void main(String[] args) {
        new ConnEtudiant();
    }
}

