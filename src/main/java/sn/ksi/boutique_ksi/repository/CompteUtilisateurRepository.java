package sn.ksi.boutique_ksi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ksi.boutique_ksi.model.CompteUtilisateur;

import java.util.Optional;

@Repository
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long> {
    Optional<CompteUtilisateur> findByUsername(String username);
}
