package sn.ksi.boutique_ksi.service;

import sn.ksi.boutique_ksi.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client createClient(Client client);
    Client findById(Long id);
    void deleteClient(Long id);
    Client findByPhone(String phone); // Ajout de la méthode

    List<Client> findAll();

    Optional<Client> getClientByPhone(String string);
}
