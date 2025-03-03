package sn.uasz.m1.projet.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper=true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Responsable")
public class Responsable extends Utilisateur{
   // @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
   private String matricule;

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
     //@Column(nullable = false)
     //private Role role;

}
