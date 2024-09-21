package sn.ksi.boutique_ksi.service;

import sn.ksi.boutique_ksi.model.Dette;
import sn.ksi.boutique_ksi.model.Paiement;

public interface PaiementService {
    Paiement createPayment(Dette debt, Paiement payment);
}

