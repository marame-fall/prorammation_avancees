package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import sn.uasz.m1.projet.model.Formation;
import sn.uasz.m1.projet.model.Responsable;
import sn.uasz.m1.projet.gui.FormationDAO;

public class ResponsableGUI extends JFrame {
    private Responsable responsableConnecte;
    private JPanel mainPanel;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtNomFormation, txtNiveauFormation;
    private JButton btnAjouter, btnModifier, btnSupprimer;

    public ResponsableGUI(Responsable responsable) {
        this.responsableConnecte = responsable;
        setTitle("Dashboard Responsable Pédagogique");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Couleurs
        Color bleuNuit = new Color(10, 10, 40);
        Color blanc = Color.WHITE;

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(bleuNuit);
        sidebar.setLayout(null);
        sidebar.setPreferredSize(new Dimension(250, getHeight()));

        String[] boutons = {"Accueil", "Les formations", "Unités d’Enseignement", "Groupes TD", "Groupes TP", "Valider inscriptions", "Liste Etudiants", "Deconnexion"};
        int yPosition = 20;

        for (String text : boutons) {
            JButton btn = new JButton(text);
            btn.setForeground(blanc);
            btn.setBackground(bleuNuit);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBounds(10, yPosition, 220, 40);

            if (text.equals("Accueil")) {
                btn.addActionListener(e -> {
                    dispose();
                    new ResponsableGUI(responsableConnecte).setVisible(true);
                });
            }
            if (text.equals("Deconnexion")) {
                btn.addActionListener(e -> {
                    int confirmation = JOptionPane.showConfirmDialog(null,
                        "Êtes-vous sûr de vouloir vous déconnecter ?",
                        "Confirmation de déconnexion",
                        JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        dispose();
                        new ConnResponsable().setVisible(true);
                    }
                });
            }
            if (text.equals("Les formations")) {
                btn.addActionListener(e -> afficherFormations());
            }
            sidebar.add(btn);
            yPosition += 50;
        }

        // Image en bas de la sidebar
        ImageIcon imageIcon = new ImageIcon("/home/sagnane/Musique/admin.jpg");
        ImageIcon resizedIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(220, 200, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(12, 480, 220, 200);
        sidebar.add(imageLabel);

        // Panel principal (blanc avec bord arrondi)
        mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(bleuNuit);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.setColor(blanc);
                g2.fillRoundRect(5, 15, getWidth() - 10, getHeight() - 30, 22, 25);
            }
        };
        mainPanel.setBackground(blanc);
        
        JLabel welcomeLabel = new JLabel("Bienvenue dans votre espace de gestion", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void afficherFormations() {
        mainPanel.removeAll();  // Supprime les anciens composants
        mainPanel.revalidate(); // Mets à jour l'affichage
        mainPanel.repaint();    // Redessine le panel
    
        JPanel gestionPanel = new JPanel(new BorderLayout());
        gestionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Tableau
        tableModel = new DefaultTableModel(new String[]{"ID", "Nom Formation", "Niveau"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
    
        // Formulaire
        JPanel formPanel = new JPanel(new FlowLayout());
        txtNomFormation = new JTextField(15);
        txtNiveauFormation = new JTextField(10);
        btnAjouter = new JButton("Ajouter");
        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");
        JButton btnVoir = new JButton("Voir");
    
        formPanel.add(new JLabel("Nom Formation :"));
        formPanel.add(txtNomFormation);
        formPanel.add(new JLabel("Niveau :"));
        formPanel.add(txtNiveauFormation);
        formPanel.add(btnAjouter);
        formPanel.add(btnModifier);
        formPanel.add(btnSupprimer);
        formPanel.add(btnVoir);
    
        // Actions des boutons
        btnAjouter.addActionListener(e -> ajouterFormation());
        btnModifier.addActionListener(e -> modifierFormation());
        btnSupprimer.addActionListener(e -> supprimerFormation());
        btnVoir.addActionListener(e -> afficherFormations());
    
        gestionPanel.add(scrollPane, BorderLayout.CENTER);
        gestionPanel.add(formPanel, BorderLayout.SOUTH);
    
        // Charger les formations depuis la base de données
        FormationDAO formationDAO = new FormationDAO();
        List<Formation> formations = formationDAO.getAllFormations();
        for (Formation formation : formations) {
            tableModel.addRow(new Object[]{formation.getId(), formation.getNom(), formation.getNiveau()});
        }
    
        mainPanel.add(gestionPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void ajouterFormation() {
        String nom = txtNomFormation.getText().trim();
        String niveau = txtNiveauFormation.getText().trim();
        if (!nom.isEmpty() && !niveau.isEmpty()) {
            Formation formation = new Formation();
            formation.setNom(nom);
            formation.setNiveau(niveau);
            formation.setResponsable(responsableConnecte);

            FormationDAO formationDAO = new FormationDAO();
            formationDAO.ajouterFormation(formation);

            afficherFormations(); // Recharger les données
            txtNomFormation.setText("");
            txtNiveauFormation.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modifierFormation() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String nom = txtNomFormation.getText().trim();
            String niveau = txtNiveauFormation.getText().trim();

            if (!nom.isEmpty() && !niveau.isEmpty()) {
                FormationDAO formationDAO = new FormationDAO();
                formationDAO.modifierFormation(id, nom, niveau);
                afficherFormations(); // Recharger les données
            }
        }
    }

    private void supprimerFormation() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            FormationDAO formationDAO = new FormationDAO();
            formationDAO.supprimerFormation(id);
            afficherFormations(); // Recharger les données
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConnResponsable().setVisible(true));
    }
}
