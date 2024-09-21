package sn.ksi.boutique_ksi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String phone;
    private String address;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean hasAccount = false;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Dette> debts = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compte_utilisateur_id")
    @JsonManagedReference
    private CompteUtilisateur compteUtilisateur;

}