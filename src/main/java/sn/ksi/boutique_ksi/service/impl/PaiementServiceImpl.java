package sn.ksi.boutique_ksi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ksi.boutique_ksi.model.Dette;
import sn.ksi.boutique_ksi.model.Paiement;
import sn.ksi.boutique_ksi.repository.PaiementRepository;
import sn.ksi.boutique_ksi.service.PaiementService;


@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementRepository paymentRepository;

    @Override
    public Paiement createPayment(Dette debt, Paiement payment) {
        payment.setDebt(debt);
        return paymentRepository.save(payment);
    }
}