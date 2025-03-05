package sn.uasz.m1.projet.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConnResponsable extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public ConnResponsable() {
        setTitle("Connexion Responsable");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Utilise ImagePanel comme fond
        ImagePanel backgroundPanel = new ImagePanel("/image/ath.jpeg"); // Remplace par le chemin de ton image
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels et champs de texte
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        backgroundPanel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        backgroundPanel.add(passwordField, gbc);

        // Boutons
        loginButton = createStyledButton("Se connecter");
        cancelButton = createStyledButton("Annuler");

        gbc.gridx = 0;
        gbc.gridy = 2;
        backgroundPanel.add(loginButton, gbc);

        gbc.gridx = 1;
        backgroundPanel.add(cancelButton, gbc);

        // Action des boutons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifierIdentifiants();
            }
        });

        cancelButton.addActionListener(e -> dispose()); // Ferme la fenêtre

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        button.setFocusPainted(false);
        return button;
    }

    private void verifierIdentifiants() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Vérification basique (à remplacer par une vérification en base de données)
        if ("admin@uasz.sn".equals(email) && "admin123".equals(password)) {
            JOptionPane.showMessageDialog(this, "Connexion réussie !");
            dispose(); // Fermer la fenêtre après connexion réussie
            // Rediriger vers l'interface du responsable pédagogique
            new IdentificationResponsable();
        } else {
            JOptionPane.showMessageDialog(this, "Email ou mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Classe ImagePanel pour l'image de fond
    static class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(String imagePath) {
            try {
                URL imgUrl = getClass().getResource(imagePath);
                if (imgUrl != null) {
                    image = ImageIO.read(imgUrl);
                } else {
                    System.err.println("Image not found: " + imagePath);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}