package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

//import sn.uasz.m1.projet.gui.FormationDAO;
import sn.uasz.m1.projet.model.Formation;
import sn.uasz.m1.projet.model.Responsable;

public class ResponsableGUI extends JFrame {
    private Responsable responsableConnecte;
    private JPanel mainPanel;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtNomFormation, txtNiveauFormation;
    private JButton btnAjouter, btnModifier, btnSupprimer;
    private Long idCounter = (long) 1;

    public ResponsableGUI(Responsable responsable) {
        this.responsableConnecte = responsable;
        setTitle("Dashboard Responsable Pédagogique");
        setSize(1500, 1000);
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

            if (text.equals("Unités d’Enseignement")) {
                btn.addActionListener(e -> afficherUes());
            }

            sidebar.add(btn);
            yPosition += 50;
        }

        // Image en bas de la sidebar
        ImageIcon imageIcon = new ImageIcon("/home/sagnane/Musique/admin.jpg");
        ImageIcon resizedIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(220, 200, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(12, 480, 200, 180);
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
                g2.fillRoundRect(5, 15, getWidth() - 10, getHeight() - 20, 22, 25);
            }
        };

        mainPanel.setBackground(blanc);

        JLabel welcomeLabel = new JLabel("Bienvenue dans votre espace de gestion", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Création du panel de contenu (les cartes)
        JPanel contentPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Ajout des 6 cartes (ici vous utilisez votre CardPanel par exemple)
        contentPanel.add(new CardPanel("/home/sagnane/Musique/EtudiantTd.jpg", "", "Listes Formations"));
        contentPanel.add(new CardPanel("/home/sagnane/Musique/EtudiantTd.jpg", "", "Listes Formations"));
        contentPanel.add(new CardPanel("/home/sagnane/Musique/EtudiantTd.jpg", "", "Listes Formations"));
        contentPanel.add(new CardPanel("/home/sagnane/Musique/EtudiantTd.jpg", "", "Listes Formations"));
        contentPanel.add(new CardPanel("/home/sagnane/Musique/EtudiantTd.jpg", "", "Listes Formations"));
        contentPanel.add(new CardPanel("/home/sagnane/Musique/EtudiantTd.jpg", "", "Listes Formations"));

        // Encapsulation du contentPanel dans un conteneur avec des marges
        JPanel contentHolder = new JPanel(new BorderLayout());
        contentHolder.setOpaque(false);
        contentHolder.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentHolder.add(contentPanel, BorderLayout.CENTER);

        // Ajout du contentHolder dans le mainPanel (il sera donc bien contenu dans le rectangle blanc)
        mainPanel.add(contentHolder, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void afficherUes() {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());

        // 🎯 1. Ajout du titre
        JLabel titleLabel = new JLabel("Gestion des Unités d’Enseignement", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // 🎯 2. Création du panel formulaire
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 🎯 Labels et champs de texte
        JLabel lblCode = new JLabel("Code :");
        JLabel lblNom = new JLabel("Nom :");
        JLabel lblVolumeHoraire = new JLabel("Volume Horaire :");
        JLabel lblCoefficient = new JLabel("Coefficient :");
        JLabel lblCredits = new JLabel("Crédits :");
        JLabel lblEnseignant = new JLabel("Enseignant :");
        JLabel lblType = new JLabel("Type :");

        JTextField txtCode = new JTextField();
        JTextField txtNom = new JTextField();
        JTextField txtVolumeHoraire = new JTextField();
        JTextField txtCoefficient = new JTextField();
        JTextField txtCredits = new JTextField();
        JTextField txtEnseignant = new JTextField();

        // 🎯 Nouveau champ de sélection : Obligatoire ou Optionnel
        JRadioButton rbObligatoire = new JRadioButton("Obligatoire");
        JRadioButton rbOptionnel = new JRadioButton("Optionnel");
        ButtonGroup bgType = new ButtonGroup();
        bgType.add(rbObligatoire);
        bgType.add(rbOptionnel);
        rbOptionnel.setSelected(true); // Par défaut, optionnel

        // 🎯 3. Définir la taille réduite des champs
        Dimension fieldSize = new Dimension(250, 40);
        txtCode.setPreferredSize(fieldSize);
        txtNom.setPreferredSize(fieldSize);
        txtVolumeHoraire.setPreferredSize(fieldSize);
        txtCoefficient.setPreferredSize(fieldSize);
        txtCredits.setPreferredSize(fieldSize);
        txtEnseignant.setPreferredSize(fieldSize);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setPreferredSize(new Dimension(80, 35));
        btnAjouter.setBackground(new Color(10, 10, 40));
        btnAjouter.setForeground(Color.WHITE);
        btnAjouter.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnAjouter.setFocusPainted(false);
        btnAjouter.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // 🎯 4. Ajout des éléments au formulaire
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(lblCode, gbc);
        gbc.gridx = 1; gbc.gridy = 0; formPanel.add(txtCode, gbc);

        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(lblNom, gbc);
        gbc.gridx = 1; gbc.gridy = 1; formPanel.add(txtNom, gbc);

        gbc.gridx = 0; gbc.gridy = 2; formPanel.add(lblVolumeHoraire, gbc);
        gbc.gridx = 1; gbc.gridy = 2; formPanel.add(txtVolumeHoraire, gbc);

        gbc.gridx = 0; gbc.gridy = 3; formPanel.add(lblCoefficient, gbc);
        gbc.gridx = 1; gbc.gridy = 3; formPanel.add(txtCoefficient, gbc);

        gbc.gridx = 0; gbc.gridy = 4; formPanel.add(lblCredits, gbc);
        gbc.gridx = 1; gbc.gridy = 4; formPanel.add(txtCredits, gbc);

        gbc.gridx = 0; gbc.gridy = 5; formPanel.add(lblEnseignant, gbc);
        gbc.gridx = 1; gbc.gridy = 5; formPanel.add(txtEnseignant, gbc);

        gbc.gridx = 0; gbc.gridy = 6; formPanel.add(lblType, gbc);
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        typePanel.add(rbObligatoire);
        typePanel.add(rbOptionnel);
        gbc.gridx = 1; gbc.gridy = 6; formPanel.add(typePanel, gbc);

        gbc.gridx = 1; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(btnAjouter, gbc);

        // 🎯 6. Permettre le redimensionnement avec un JScrollPane
        JScrollPane scrollPane = new JScrollPane(formPanel);

        // Encapsuler le scrollPane dans un conteneur avec des marges pour qu'il reste à l'intérieur du panel blanc
        JPanel container = new JPanel(new BorderLayout());
        container.setOpaque(false);
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        container.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(container, BorderLayout.CENTER);

        // 🎯 7. Ajout en base de données lors du clic sur "Ajouter"
        btnAjouter.addActionListener(e -> {
            String code = txtCode.getText().trim();
            String nom = txtNom.getText().trim();
            String volumeHoraire = txtVolumeHoraire.getText().trim();
            String coefficient = txtCoefficient.getText().trim();
            String credits = txtCredits.getText().trim();
            String enseignant = txtEnseignant.getText().trim();
            boolean obligatoire = rbObligatoire.isSelected();

            // Vérifier que les champs ne sont pas vides
            if (code.isEmpty() || nom.isEmpty() || volumeHoraire.isEmpty() ||
            coefficient.isEmpty() || credits.isEmpty() || enseignant.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Tous les champs sont obligatoires !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
             // Création de l'UE
                UniteEnseignement ue = new UniteEnseignement();
                ue.setCode(code);
                ue.setNom(nom);
                ue.setVolumeHoraire(Integer.parseInt(volumeHoraire));
                ue.setCoefficient(Integer.parseInt(coefficient));
                ue.setCredits(Integer.parseInt(credits));
                ue.setEnseignant(enseignant);
                ue.setObligatoire(obligatoire);

                // Sauvegarde en base avec Hibernate
                UniteEnseignementDAO ueDAO = new UniteEnseignementDAO();
                ueDAO.ajouterUniteEnseignement(ue);

                // Message de confirmation
                JOptionPane.showMessageDialog(mainPanel, "Unité d'enseignement ajoutée avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);

                // 🎯 8. Réinitialiser les champs après l'ajout
                txtCode.setText("");
                txtNom.setText("");
                txtVolumeHoraire.setText("");
                txtCoefficient.setText("");
                txtCredits.setText("");
                txtEnseignant.setText("");
                rbOptionnel.setSelected(true);

            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Veuillez entrer des nombres valides pour Volume Horaire, Coefficient et Crédits.", "Erreur de format", JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, "Erreur lors de l'ajout : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void afficherFormations() {
        // 🟠 Réinitialisation du mainPanel
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    
        // 🟠 Ajout du titre
        JLabel titleLabel = new JLabel("Gestion des Formations", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
    
        // 🟠 Conteneur principal pour éviter le débordement
        JPanel container = new JPanel(new BorderLayout());
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Ajout d'espaces autour
        container.setOpaque(false);
    
        // 🟠 Table pour afficher les formations
        tableModel = new DefaultTableModel(new String[]{"ID", "Nom Formation", "Niveau"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); // Permet de scroller si la liste est longue
    
        // 🟠 Ajout d'un événement pour récupérer les données sélectionnées
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    txtNomFormation.setText((String) tableModel.getValueAt(selectedRow, 1));
                    txtNiveauFormation.setText((String) tableModel.getValueAt(selectedRow, 2));
                }
            }
        });
    
        // 🟠 Création du panel formulaire avec GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        // Champs de saisie
        txtNomFormation = new JTextField(15);
        txtNiveauFormation = new JTextField(10);
        
        // Boutons
        btnAjouter = new JButton("Ajouter");
        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");
    
        // 🟠 Ajout des composants au formulaire
        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(new JLabel("Nom Formation :"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; formPanel.add(txtNomFormation, gbc);
    
        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(new JLabel("Niveau :"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; formPanel.add(txtNiveauFormation, gbc);
    
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2; // Étendre les boutons sur deux colonnes
        gbc.anchor = GridBagConstraints.CENTER;
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnAjouter);
        buttonPanel.add(btnModifier);
        buttonPanel.add(btnSupprimer);
        
        formPanel.add(buttonPanel, gbc);
    
        // 🟠 Ajout des boutons avec actions
        btnAjouter.addActionListener(e -> ajouterFormation());
        btnModifier.addActionListener(e -> modifierFormation());
        btnSupprimer.addActionListener(e -> supprimerFormation());
    
        // 🟠 Chargement des formations depuis la base de données
        FormationDAO formationDAO = new FormationDAO();
        List<Formation> formations = formationDAO.getAllFormations();
        for (Formation formation : formations) {
            tableModel.addRow(new Object[]{formation.getId(), formation.getNom(), formation.getNiveau()});
        }
    
        // 🟠 Ajout des éléments au conteneur
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(formPanel, BorderLayout.SOUTH);
    
        // 🟠 Ajout du conteneur dans mainPanel
        mainPanel.add(container, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void ajouterFormation() {
        String nom = txtNomFormation.getText().trim();
        String niveau = txtNiveauFormation.getText().trim();
        if (!nom.isEmpty() && !niveau.isEmpty()) {
            Formation formation = new Formation();
            formation.setId((Long) idCounter);
            formation.setNom(nom);
            formation.setNiveau(niveau);
            formation.setResponsable(responsableConnecte); // Assigner le responsable connecté
    
            FormationDAO formationDAO = new FormationDAO();
            formationDAO.ajouterFormation(formation);
    
            // Ajouter la formation au tableau avec l'ID généré automatiquement
            tableModel.addRow(new Object[]{idCounter, formation.getNom(), formation.getNiveau()});
    
            // Réinitialiser les champs
            txtNomFormation.setText("");
            txtNiveauFormation.setText("");

             // Incrémenter le compteur pour le prochain ID
            idCounter++;
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void modifierFormation() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) tableModel.getValueAt(selectedRow, 0);
            String nom = txtNomFormation.getText().trim();
            String niveau = txtNiveauFormation.getText().trim();

            if (!nom.isEmpty() && !niveau.isEmpty()) {
                FormationDAO formationDAO = new FormationDAO();
                Formation formationExistante = formationDAO.getFormationById(id);
                //formationExistante.setId(id);
                formationExistante.setNom(nom);
                formationExistante.setNiveau(niveau);
                formationExistante.setResponsable(responsableConnecte);

                //FormationDAO formationDAO = new FormationDAO();
                formationDAO.modifierFormation(formationExistante);

                // Mettre à jour le tableau
                tableModel.setValueAt(nom, selectedRow, 1);
                tableModel.setValueAt(niveau, selectedRow, 2);

                 // Réinitialiser les champs
                txtNomFormation.setText("");
                txtNiveauFormation.setText("");

                //afficherFormations();

                JOptionPane.showMessageDialog(this, "Formation mise à jour avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une formation à modifier.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void supprimerFormation() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) tableModel.getValueAt(selectedRow, 0);

            int confirmation = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette formation ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                FormationDAO formationDAO = new FormationDAO();
                formationDAO.supprimerFormation(id);

            // Supprimer de la vue (tableau)
            tableModel.removeRow(selectedRow);  // Supprimer la ligne sélectionnée dans le tableau

                //afficherFormations();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une formation à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /*private void modifierUE(JTextField txtCode, JTextField txtNom, JTextField txtVolumeHoraire, JTextField txtCoefficient, JTextField txtCredits, JTextField txtEnseignant) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String code = (String) tableModel.getValueAt(selectedRow, 0);
            String nom = txtNom.getText().trim();
            String volumeHoraire = txtVolumeHoraire.getText().trim();
            String coefficient = txtCoefficient.getText().trim();
            String credits = txtCredits.getText().trim();
            String enseignant = txtEnseignant.getText().trim();
    
            if (!nom.isEmpty() && !volumeHoraire.isEmpty() && !coefficient.isEmpty() && !credits.isEmpty() && !enseignant.isEmpty()) {
                UE ue = new UE();
                ue.setCode(code);
                ue.setNom(nom);
                ue.setVolumeHoraire(volumeHoraire);
                ue.setCoefficient(coefficient);
                ue.setCredit(credits);
                ue.setEnseignantResponsable(enseignant);
    
                FormationDAO formationDAO = new FormationDAO();
                formationDAO.modifierUe(ue); // Modifier l'UE dans la base de données
    
                // Mettre à jour le tableau
                tableModel.setValueAt(nom, selectedRow, 1);
                tableModel.setValueAt(volumeHoraire, selectedRow, 2);
                tableModel.setValueAt(coefficient, selectedRow, 3);
                tableModel.setValueAt(credits, selectedRow, 4);
                tableModel.setValueAt(enseignant, selectedRow, 5);
    
                // Réinitialiser les champs
                txtNom.setText("");
                txtVolumeHoraire.setText("");
                txtCoefficient.setText("");
                txtCredits.setText("");
                txtEnseignant.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une UE à modifier.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void supprimerUE() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String code = (String) tableModel.getValueAt(selectedRow, 0);
    
            int confirmation = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette UE ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                FormationDAO formationDAO = new FormationDAO();
                formationDAO.supprimerUe(code); // Supprimer l'UE de la base de données
    
                // Supprimer de la vue (tableau)
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une UE à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConnResponsable().setVisible(true));
    }
}
