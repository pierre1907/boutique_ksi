package sn.ksi.boutique_ksi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.ksi.boutique_ksi.model.Dette;
import sn.ksi.boutique_ksi.model.Paiement;
import sn.ksi.boutique_ksi.service.DetteService;
import sn.ksi.boutique_ksi.service.PaiementService;

import java.util.Optional;


@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final PaiementService paymentService;
    private final DetteService debtService;

    @Autowired
    public PaiementController(PaiementService paymentService, DetteService debtService) {
        this.paymentService = paymentService;
        this.debtService = debtService;
    }

    // Enregistrer un paiement pour une dette non soldée
    @PostMapping("/{debtId}")
    public ResponseEntity<Paiement> createPayment(@PathVariable Long debtId, @RequestBody Paiement payment) {
        Optional<Dette> debtOpt = debtService.getAllDettes().stream()
                .filter(debt -> debt.getId().equals(debtId) && !debt.isPaid())  // Filtrer pour obtenir les dettes non soldées
                .findFirst();
        if (debtOpt.isPresent()) {
            Dette debt = debtOpt.get();
            Paiement createdPayment = paymentService.createPayment(debt, payment);
            return ResponseEntity.ok(createdPayment);
        }
        return ResponseEntity.notFound().build();
    }
}