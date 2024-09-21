package sn.ksi.boutique_ksi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ksi.boutique_ksi.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByPhone(String phone);
}
