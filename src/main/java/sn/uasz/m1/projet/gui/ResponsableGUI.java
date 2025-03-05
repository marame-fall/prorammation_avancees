package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ResponsableGUI extends JFrame {
    public ResponsableGUI() {
        setTitle("Dashboard Responsable Pédagogique");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Couleurs
        Color bleuNuit = new Color(10, 10, 40);
        Color blanc = Color.WHITE;

        // Panel latéral
        JPanel sidebar = new JPanel();
        sidebar.setBackground(bleuNuit);
        sidebar.setLayout(null);
        sidebar.setPreferredSize(new Dimension(250, getHeight()));

        sidebar.setBounds(0, 0, 250, getHeight());

        // Boutons du menu avec espacement entre chaque
        String[] boutons = {
            "Accueil",
            "Les formations",
            "Unités d’Enseignement",
            "Groupes TD",
            "Groupes TP",
            "Valider inscriptions",
            "Liste Etudiants",
            "Deconnexion"
        };

        int yPosition = 20; // Position verticale de départ pour les boutons

        for (String text : boutons) {
            JButton btn = new JButton(text);
            btn.setForeground(blanc);
            btn.setBackground(bleuNuit);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBounds(10, yPosition, 220, 40);

            // ActionListener pour le bouton "Accueil"
            if (text.equals("Accueil")) {
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose(); // Ferme la fenêtre actuelle
                        new ResponsableGUI().setVisible(true); // Ouvre une nouvelle instance de ResponsableGUI
                    }
                });
            }

            // ActionListener pour le bouton "Déconnexion"
            if (text.equals("Deconnexion")) {
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int confirmation = JOptionPane.showConfirmDialog(null, 
                            "Êtes-vous sûr de vouloir vous déconnecter ?", 
                            "Confirmation de déconnexion", 
                            JOptionPane.YES_NO_OPTION);

                        if (confirmation == JOptionPane.YES_OPTION) {
                            dispose(); // Ferme la fenêtre actuelle
                            new ConnResponsable().setVisible(true); // Retour à la page ConnResponsable
                        }
                    }
                });
            }

            sidebar.add(btn);
            yPosition += 50; // Espacement entre les boutons
        }

        // Revalidate et repaint pour assurer que les composants sont bien rendus
        sidebar.revalidate();
        sidebar.repaint();

        // Ajout d'une image en bas du panneau latéral avec redimensionnement
        ImageIcon imageIcon = new ImageIcon("/home/sagnane/Musique/admin.jpg");
        ImageIcon resizedIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(220, 200, java.awt.Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(12, 480, 220, 200);
        sidebar.add(imageLabel);

        // Contenu principal avec bordure et coins arrondis
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(bleuNuit);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.setColor(blanc);
                g2.fillRoundRect(5, 8, getWidth() - 10, getHeight() - 16, 25, 25);
            }
        };
        mainPanel.setBackground(bleuNuit);
        mainPanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Bienvenue dans votre espace de gestion", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); // Descendre le texte
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Ajout des panneaux
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ResponsableGUI().setVisible(true));
    }
}
