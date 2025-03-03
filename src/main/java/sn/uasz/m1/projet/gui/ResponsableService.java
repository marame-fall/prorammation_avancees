package sn.uasz.m1.projet.gui;

//mport sn.uasz.m1.projet.gui.ResponsableDAO;
import sn.uasz.m1.projet.model.Utilisateur;

import java.util.Optional;

public class ResponsableService {
    private final ResponsableDAO responsableDAO;

    public ResponsableService() {
        this.responsableDAO = new ResponsableDAO();
    }

    public boolean authenticate(String email, String password) {
        Optional<Utilisateur> utilisateurOpt = responsableDAO.findByEmail(email);
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            return utilisateur.getMotDePasse().equals(password);
        }
        return false;
    }
}
