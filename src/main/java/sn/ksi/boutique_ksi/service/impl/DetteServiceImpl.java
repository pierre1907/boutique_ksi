package sn.ksi.boutique_ksi.service.impl;

import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.model.Dette;
import sn.ksi.boutique_ksi.repository.DetteRepository;
import sn.ksi.boutique_ksi.service.DetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetteServiceImpl implements DetteService {

    @Autowired
    private DetteRepository detteRepository;

    @Override
    public Dette createDebt(Client client, Dette debt) {
        debt.setClient(client);
        return detteRepository.save(debt);
    }

    @Override
    public List<Dette> getUnpaidDebtsForClient(Client client) {
        return detteRepository.findByClientAndIsPaidFalse(client);
    }

    @Override
    public List<Dette> getAllDettes() {
        return detteRepository.findAll();
    }
}
