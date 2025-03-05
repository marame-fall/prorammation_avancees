package sn.uasz.m1.projet.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ResponsableGUI extends JFrame {
    public ResponsableGUI() {
        setTitle("Espace Responsable Pédagogique");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton btnGestionFormations = new JButton("Gérer les formations");
        JButton btnGestionUEs = new JButton("Gérer les unités d’enseignement");
        JButton btnGestionGroupes = new JButton("Gérer les groupes TD/TP");
        JButton btnValidationInscriptions = new JButton("Valider inscriptions");
        JButton btnListerEtudiants = new JButton("Lister les étudiants");
        JButton btnQuitter = new JButton("Quitter");

        /*btnGestionFormations.addActionListener(
            e -> new GestionFormationGUI().setVisible(true));
        btnGestionUEs.addActionListener(
            e -> new GestionUEGUI().setVisible(true));
        btnGestionGroupes.addActionListener(
            e -> new GestionGroupeGUI().setVisible(true));
        btnValidationInscriptions.addActionListener(
            e -> new ValidationInscriptionGUI().setVisible(true));
        btnListerEtudiants.addActionListener(
            e -> new ListerEtudiantsGUI().setVisible(true));
        btnQuitter.addActionListener(
            e -> dispose());*/

        panel.add(btnGestionFormations);
        panel.add(btnGestionUEs);
        panel.add(btnGestionGroupes);
        panel.add(btnValidationInscriptions);
        panel.add(btnListerEtudiants);
        panel.add(btnQuitter);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ResponsableGUI().setVisible(true));
    }
}
