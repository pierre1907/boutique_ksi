package sn.ksi.boutique_ksi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.model.CompteUtilisateur;
import sn.ksi.boutique_ksi.service.CompteUtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
public class CompteUtilisateurController {

    @Autowired
    private CompteUtilisateurService compteUtilisateurService;

    // Créer un compte utilisateur
    @PostMapping("/create")
    public ResponseEntity<CompteUtilisateur> createCompteUtilisateur(
            @RequestBody Client client, @RequestBody CompteUtilisateur compte) {
        CompteUtilisateur newCompte = compteUtilisateurService.createCompteUtilisateur(client, compte);
        return ResponseEntity.ok(newCompte);
    }

    // Obtenir un compte utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<CompteUtilisateur> getCompteById(@PathVariable Long id) {
        CompteUtilisateur compte = compteUtilisateurService.findById(id);
        return ResponseEntity.ok(compte);
    }

    // Supprimer un compte utilisateur
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompte(@PathVariable Long id) {
        compteUtilisateurService.deleteCompte(id);
        return ResponseEntity.ok("Compte supprimé avec succès");
    }

    // Obtenir tous les clients avec un compte utilisateur
    @GetMapping("/avec-compte")
    public ResponseEntity<List<CompteUtilisateur>> getClientsWithAccount() {
        List<CompteUtilisateur> comptes = compteUtilisateurService.getClientsWithAccount();
        return ResponseEntity.ok(comptes);
    }

    // Obtenir tous les clients sans compte utilisateur
    @GetMapping("/sans-compte")
    public ResponseEntity<List<CompteUtilisateur>> getClientsWithoutAccount() {
        List<CompteUtilisateur> clients = compteUtilisateurService.getClientsWithoutAccount();
        return ResponseEntity.ok(clients);
    }

    // Obtenir un compte utilisateur par email (ou login)
    @GetMapping("/username/{username}")
    public ResponseEntity<CompteUtilisateur> findByUsername(@PathVariable String username) {
        CompteUtilisateur compte = compteUtilisateurService.findByUsername(username);
        return ResponseEntity.ok(compte);
    }

    // Obtenir les détails d'un compte utilisateur
    @GetMapping("/details/{id}")
    public ResponseEntity<CompteUtilisateur> getCompteDetails(@PathVariable Long id) {
        CompteUtilisateur compte = compteUtilisateurService.findById(id);
        return ResponseEntity.ok(compte);
    }
}
