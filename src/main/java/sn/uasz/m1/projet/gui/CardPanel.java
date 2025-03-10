package sn.uasz.m1.projet.gui;

/*import java.awt.*;
import javax.swing.*;

public class CardPanel extends JPanel {

    private String title;
    private String value;
    private String subText;

    public CardPanel(String title, String value, String subText) {
        this.title = title;
        this.value = value;
        this.subText = subText;

        // Taille préférée pour la carte (à ajuster selon ton design)
        setPreferredSize(new Dimension(200, 90));
        setOpaque(false);

        // Utilisons un BorderLayout pour disposer titre (NORTH), valeur (CENTER), sous-texte (SOUTH)
        setLayout(new BorderLayout(5, 5));

        // Label du titre
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        titleLabel.setForeground(new Color(80, 80, 80));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 8, 0, 8));

        // Label de la valeur
        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 22));
        valueLabel.setForeground(new Color(60, 120, 60));

        // Label du sous-texte (exemple : "5.6% Since Last Month")
        JLabel subLabel = new JLabel(subText, SwingConstants.RIGHT);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subLabel.setForeground(new Color(100, 180, 100));
        subLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 5, 8));

        // Ajout des labels au panel
        add(titleLabel, BorderLayout.NORTH);
        add(valueLabel, BorderLayout.CENTER);
        add(subLabel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Activer l'anti-aliasing
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessiner le fond arrondi
        int arc = 15;
        int w = getWidth();
        int h = getHeight();

        // Couleur de fond
        g2.setColor(new Color(245, 245, 245));
        g2.fillRoundRect(0, 0, w, h, arc, arc);

        // Dessiner la bordure
        g2.setColor(new Color(200, 200, 200));
        g2.drawRoundRect(0, 0, w - 1, h - 1, arc, arc);

        g2.dispose();
    }
}*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardPanel extends JPanel {

    public CardPanel(String imagePath, String titre, String boutonTexte) {
        
        // Dimension réduite pour la carte
        setPreferredSize(new Dimension(50, 10));
        setOpaque(false);
        setLayout(new BorderLayout(5, 5));
        

        // 🔹 Ajouter une image centrée
        ImageIcon icon = new ImageIcon(imagePath); // Image de la carte
        Image img = icon.getImage().getScaledInstance(220, 180, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img), SwingConstants.CENTER);

        // 🔹 Ajouter le titre en haut
        JLabel titreLabel = new JLabel(titre, SwingConstants.CENTER);
        titreLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // 🔹 Ajouter un bouton en bas
        JButton btnAction = new JButton(boutonTexte);
        btnAction.addActionListener(e -> JOptionPane.showMessageDialog(null, "Vous avez cliqué sur : " + titre));
        JLabel subLabel = new JLabel(boutonTexte, SwingConstants.RIGHT);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        subLabel.setForeground(new Color(100, 180, 100));
        subLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 5, 8));

        // 🎯 Ajouter les composants
        add(titreLabel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
        add(btnAction, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 15;
        int w = getWidth();
        int h = getHeight();

        g2.setColor(new Color(245, 245, 245));
        g2.fillRoundRect(0, 0, w, h, arc, arc);

        g2.setColor(new Color(200, 200, 200));
        g2.drawRoundRect(0, 0, w - 1, h - 1, arc, arc);

        g2.dispose();
    }
}


