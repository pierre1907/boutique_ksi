package sn.ksi.boutique_ksi.repository;

import sn.ksi.boutique_ksi.model.Dette;
import sn.ksi.boutique_ksi.model.Client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetteRepository extends JpaRepository<Dette, Long> {
     List<Dette> findByClientAndIsPaidFalse(Client client);
}
