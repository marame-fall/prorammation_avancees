package sn.uasz.m1.projet.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String sexe;

    @Column(nullable = false)
    private String motDePasse;

    //@Enumerated(EnumType.STRING) // Indique que le rôle est stocké sous forme de chaîne
   // @Column(nullable = false)
    //private Role role;

    // @Enumerated(EnumType.STRING) // Indique que le rôle est stocké sous forme de chaîne
    // @Column(nullable = false)
    // private Role role;

   // public String getRole() {
      //  throw new UnsupportedOperationException("Not supported yet.");
    //}
}
