package sn.ksi.boutique_ksi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.model.CompteUtilisateur;
import sn.ksi.boutique_ksi.repository.CompteUtilisateurRepository;
import sn.ksi.boutique_ksi.service.CompteUtilisateurService;

import java.util.List;

@Service
public class CompteUtilisateurServiceImpl implements CompteUtilisateurService {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;

    @Override
    public CompteUtilisateur createCompteUtilisateur(Client client, CompteUtilisateur compte) {
        // Logique pour créer un compte utilisateur
        return compteUtilisateurRepository.save(compte);
    }

    @Override
    public CompteUtilisateur findById(Long id) {
        return compteUtilisateurRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCompte(Long id) {
        compteUtilisateurRepository.deleteById(id);
    }

    @Override
    public List<CompteUtilisateur> getClientsWithAccount() {
        // Logique pour récupérer les clients avec un compte
        return compteUtilisateurRepository.findAll(); // Modifiez selon votre logique
    }

    @Override
    public List<CompteUtilisateur> getClientsWithoutAccount() {
        // Logique pour récupérer les clients sans compte
        return compteUtilisateurRepository.findAll(); // Modifiez selon votre logique
    }

    @Override
    public CompteUtilisateur findByUsername(String username) {
        return compteUtilisateurRepository.findByUsername(username).orElse(null);
    }
}
