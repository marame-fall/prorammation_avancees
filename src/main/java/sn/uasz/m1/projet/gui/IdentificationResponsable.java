package sn.uasz.m1.projet.gui;

import javax.swing.*;

public class IdentificationResponsable extends JFrame {
    public IdentificationResponsable() {
        setTitle("Identification Responsable");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Page d'identification des responsables", SwingConstants.CENTER);
        add(label);
    }
}
