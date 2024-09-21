package sn.ksi.boutique_ksi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.repository.ClientRepository;
import sn.ksi.boutique_ksi.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findByPhone(String phone) {
        return clientRepository.findByPhone(phone);
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public Optional<Client> getClientByPhone(String string) {
        return Optional.empty();
    }
}
