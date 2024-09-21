package sn.ksi.boutique_ksi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.ksi.boutique_ksi.model.Paiement;


@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}