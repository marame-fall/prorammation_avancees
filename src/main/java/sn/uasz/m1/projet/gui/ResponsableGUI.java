package sn.uasz.m1.projet.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
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

//import sn.uasz.m1.projet.gui.FormationDAO;
import sn.uasz.m1.projet.model.Formation;
import sn.uasz.m1.projet.model.Responsable;
import sn.uasz.m1.projet.model.UE;

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

            if (text.equals("Unités d’Enseignement")) {
                btn.addActionListener(e -> afficherUes());
            }

            sidebar.add(btn);
            yPosition += 50;
        }

        // Panel principal (blanc avec bord arrondi)
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(blanc);
        
        JLabel welcomeLabel = new JLabel("Bienvenue dans votre espace de gestion", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    /*private void afficherUes() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    
        JPanel gestionPanel = new JPanel(new BorderLayout());
        gestionPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    
        tableModel = new DefaultTableModel(new String[]{"Code", "Nom", "Volume Horaire", "Coefficient", "Crédits", "Enseignant"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
    
        // Panel pour les champs de l'UE
        JPanel formPanel = new JPanel(new GridLayout(0,2,5,5));
        JTextField txtCode = new JTextField(10);
        JTextField txtNom = new JTextField(15);
        JTextField txtVolumeHoraire = new JTextField(10);
        JTextField txtCoefficient = new JTextField(10);
        JTextField txtCredits = new JTextField(10);
        JTextField txtEnseignant = new JTextField(15);
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnModifier = new JButton("Modifier");
        JButton btnSupprimer = new JButton("Supprimer");
    
        formPanel.add(new JLabel("Code :"));
        formPanel.add(txtCode);
        formPanel.add(new JLabel("Nom :"));
        formPanel.add(txtNom);
        formPanel.add(new JLabel("Volume Horaire :"));
        formPanel.add(txtVolumeHoraire);
        formPanel.add(new JLabel("Coefficient :"));
        formPanel.add(txtCoefficient);
        formPanel.add(new JLabel("Crédits :"));
        formPanel.add(txtCredits);
        formPanel.add(new JLabel("Enseignant :"));
        formPanel.add(txtEnseignant);
        formPanel.add(btnAjouter);
        formPanel.add(btnModifier);
        formPanel.add(btnSupprimer);
    
        //btnAjouter.addActionListener(e -> ajouterUE(txtCode, txtNom, txtVolumeHoraire, txtCoefficient, txtCredits, txtEnseignant));
        //btnModifier.addActionListener(e -> modifierUE(txtCode, txtNom, txtVolumeHoraire, txtCoefficient, txtCredits, txtEnseignant));
        //btnSupprimer.addActionListener(e -> supprimerUE());
    
        gestionPanel.add(scrollPane, BorderLayout.CENTER);
        gestionPanel.add(formPanel, BorderLayout.SOUTH);
    
        // Charger les UEs dans le tableau
        FormationDAO formationDAO = new FormationDAO();
        List<UE> ues = formationDAO.getAllUes(); // Assure-toi d'avoir la méthode pour récupérer les UEs
        for (UE ue : ues) {
            tableModel.addRow(new Object[]{
                ue.getCode(), 
                ue.getNom(), 
                ue.getVolumeHoraire(), 
                ue.getCoefficient(), 
                ue.getCredit(), 
                ue.getEnseignantResponsable()});
        }
    
        mainPanel.add(gestionPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }*/

    private void afficherUes() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField txtCode = new JTextField(10);
        JTextField txtNom = new JTextField(15);
        JTextField txtVolumeHoraire = new JTextField(10);
        JTextField txtCoefficient = new JTextField(10);
        JTextField txtCredits = new JTextField(10);
        JTextField txtEnseignant = new JTextField(15);
        JButton btnValider = new JButton("Valider");
    
        formPanel.add(new JLabel("Code :"));
        formPanel.add(txtCode);
        formPanel.add(new JLabel("Nom :"));
        formPanel.add(txtNom);
        formPanel.add(new JLabel("Volume Horaire :"));
        formPanel.add(txtVolumeHoraire);
        formPanel.add(new JLabel("Coefficient :"));
        formPanel.add(txtCoefficient);
        formPanel.add(new JLabel("Crédits :"));
        formPanel.add(txtCredits);
        formPanel.add(new JLabel("Enseignant :"));
        formPanel.add(txtEnseignant);
        formPanel.add(btnValider);
    
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        btnValider.addActionListener(e -> {
            // Vérification des champs
            if (txtCode.getText().isEmpty() || txtNom.getText().isEmpty() ||
                txtVolumeHoraire.getText().isEmpty() || txtCoefficient.getText().isEmpty() ||
                txtCredits.getText().isEmpty() || txtEnseignant.getText().isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Création et ajout de l'UE en base
            //UE nouvelleUE = new UE(txtCode.getText(), txtNom.getText(),
                  //  Integer.parseInt(txtVolumeHoraire.getText()), 
                   // Double.parseDouble(txtCoefficient.getText()), 
                   // Integer.parseInt(txtCredits.getText()), 
                    //txtEnseignant.getText());
            
           // FormationDAO formationDAO = new FormationDAO();
            //formationDAO.ajouterUE(nouvelleUE); // Assure-toi que cette méthode existe
    
            // Afficher la liste des UEs après ajout
            //afficherListeUes();
        });
    
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void afficherFormations() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    
        JPanel gestionPanel = new JPanel(new BorderLayout());
        gestionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        tableModel = new DefaultTableModel(new String[]{"ID", "Nom Formation", "Niveau"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    txtNomFormation.setText((String) tableModel.getValueAt(selectedRow, 1));
                    txtNiveauFormation.setText((String) tableModel.getValueAt(selectedRow, 2));
                }
            }
        });
    
        JPanel formPanel = new JPanel(new FlowLayout());
        txtNomFormation = new JTextField(15);
        txtNiveauFormation = new JTextField(10);
        btnAjouter = new JButton("Ajouter");
        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");

        formPanel.add(new JLabel("Nom Formation :"));
        formPanel.add(txtNomFormation);
        formPanel.add(new JLabel("Niveau :"));
        formPanel.add(txtNiveauFormation);
        formPanel.add(btnAjouter);
        formPanel.add(btnModifier);
        formPanel.add(btnSupprimer);
    
        btnAjouter.addActionListener(e -> ajouterFormation());
        btnModifier.addActionListener(e -> modifierFormation());
        btnSupprimer.addActionListener(e -> supprimerFormation());
    
        gestionPanel.add(scrollPane, BorderLayout.CENTER);
        gestionPanel.add(formPanel, BorderLayout.SOUTH);
    
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

    /*private void ajouterUE(JTextField txtCode, JTextField txtNom, JTextField txtVolumeHoraire, JTextField txtCoefficient, JTextField txtCredits, JTextField txtEnseignant) {
        String code = txtCode.getText().trim();
        String nom = txtNom.getText().trim();
        String volumeHoraire = txtVolumeHoraire.getText().trim();
        String coefficient = txtCoefficient.getText().trim();
        String credits = txtCredits.getText().trim();
        String enseignant = txtEnseignant.getText().trim();
    
        if (!code.isEmpty() && !nom.isEmpty() && !volumeHoraire.isEmpty() && !coefficient.isEmpty() && !credits.isEmpty() && !enseignant.isEmpty()) {
            UE ue = new UE();
            ue.setCode(code);
            ue.setNom(nom);
            ue.setVolumeHoraire(volumeHoraire);
            ue.setCoefficient(coefficient);
            ue.setCredit(credits);
            ue.setEnseignantResponsable(enseignant);
    
            FormationDAO formationDAO = new FormationDAO();
            formationDAO.ajouterUe(ue); // Ajouter la nouvelle UE à la base de données
    
            // Ajouter l'UE au tableau
            tableModel.addRow(new Object[]{code, nom, volumeHoraire, coefficient, credits, enseignant});
    
            // Réinitialiser les champs
            txtCode.setText("");
            txtNom.setText("");
            txtVolumeHoraire.setText("");
            txtCoefficient.setText("");
            txtCredits.setText("");
            txtEnseignant.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modifierUE(JTextField txtCode, JTextField txtNom, JTextField txtVolumeHoraire, JTextField txtCoefficient, JTextField txtCredits, JTextField txtEnseignant) {
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
