package sn.ksi.boutique_ksi.service;

import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.model.CompteUtilisateur;

import java.util.List;

public interface CompteUtilisateurService {
    CompteUtilisateur createCompteUtilisateur(Client client, CompteUtilisateur compte);
    CompteUtilisateur findById(Long id);
    void deleteCompte(Long id);
    List<CompteUtilisateur> getClientsWithAccount();
    List<CompteUtilisateur> getClientsWithoutAccount();
    CompteUtilisateur findByUsername(String username);
}
