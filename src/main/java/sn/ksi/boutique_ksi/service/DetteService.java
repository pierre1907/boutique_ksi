package sn.ksi.boutique_ksi.service;

import sn.ksi.boutique_ksi.model.Client;
import sn.ksi.boutique_ksi.model.Dette;
import java.util.List;

public interface DetteService {
    Dette createDebt(Client client, Dette debt);
    List<Dette> getUnpaidDebtsForClient(Client client);
    List<Dette> getAllDettes();

}
