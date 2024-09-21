package sn.ksi.boutique_ksi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.model.CompteUtilisateur;
import sn.ksi.boutique_ksi.service.ClientService;
import sn.ksi.boutique_ksi.service.CompteUtilisateurService;

import java.util.List;
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompteUtilisateurService compteUtilisateurService;

    // Ajouter un client
    @PostMapping("/add")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        if (client.isHasAccount()) {
            CompteUtilisateur compteUtilisateur = client.getCompteUtilisateur();
            if (compteUtilisateur == null ||
                    compteUtilisateur.getEmail() == null ||
                    compteUtilisateur.getUsername() == null ||
                    compteUtilisateur.getPassword() == null) {
                return ResponseEntity.badRequest().body(null);
            }
            CompteUtilisateur savedCompte = compteUtilisateurService.createCompteUtilisateur(client, compteUtilisateur);
            client.setCompteUtilisateur(savedCompte);
        }
        Client savedClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    // Obtenir un client par ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    // Supprimer un client
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client supprimé avec succès");
    }

    // Obtenir un client par numéro de téléphone
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Client> findByPhone(@PathVariable String phone) {
        Client client = clientService.findByPhone(phone);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    //obtenir tous les clients
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }
}
