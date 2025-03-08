/*package sn.uasz.m1.projet.gui;

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

//import sn.uasz.m1.projet.model.Responsable;

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
        ImagePanel backgroundPanel = new ImagePanel("/image/ath.jpeg");
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

        cancelButton.addActionListener(
            e -> dispose()); // Ferme la fenêtre

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

        if ("admin@uasz.sn".equals(email) && "admin123".equals(password)) {
            JOptionPane.showMessageDialog(this, "Connexion réussie !");
            dispose();
            new ResponsableGUI(null).setVisible(true);
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ConnResponsable extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public ConnResponsable() {
        setTitle("Connexion Responsable");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panneau principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panneau gauche avec l'image
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, 700));
        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("/image/res.jpeg")));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(imageLabel);

        // Panneau droit avec les champs de connexion
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout()); // Utilisation de GridBagLayout pour les champs
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Configuration des contraintes GridBag
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = 2;

        // Titre de bienvenue
        JLabel welcomeLabel = new JLabel("Connexion Responsable");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(70, 70, 70));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        rightPanel.add(welcomeLabel, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridy = 1;
        rightPanel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(250, 30));
        gbc.gridy = 2;
        rightPanel.add(emailField, gbc);

        // Mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridy = 3;
        rightPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(250, 30));
        gbc.gridy = 4;
        rightPanel.add(passwordField, gbc);

        // Checkbox pour afficher le mot de passe
        JCheckBox showPasswordCheckBox = new JCheckBox("Afficher le mot de passe");
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.addActionListener(e -> 
            passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '•')
        );
        gbc.gridy = 5;
        rightPanel.add(showPasswordCheckBox, gbc);

        // Bouton de connexion
        loginButton = new JButton("Se connecter");
        loginButton.setBackground(new Color(60, 179, 113));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(loginButton, gbc);

        // Bouton d'annulation
        cancelButton = new JButton("Annuler");
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(new Color(70, 70, 70));
        gbc.gridy = 7;
        rightPanel.add(cancelButton, gbc);

        // Ajouter les actions pour les boutons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifierIdentifiants();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        // Ajouter les panneaux à la fenêtre
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private void verifierIdentifiants() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Vérification des identifiants (exemple simple)
        if ("admin@uasz.sn".equals(email) && "admin123".equals(password)) {
            JOptionPane.showMessageDialog(this, "Connexion réussie !");
            dispose();
            new ResponsableGUI(null).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Email ou mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConnResponsable().setVisible(true));
    }
}
