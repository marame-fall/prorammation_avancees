package sn.uasz.m1.projet.gui ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnResponsable extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public ConnResponsable() {
        setTitle("Connexion Responsable");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Labels et champs de texte
        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Mot de passe:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Boutons
        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");

        add(loginButton);
        add(cancelButton);

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
}
