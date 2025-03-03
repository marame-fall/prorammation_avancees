package sn.uasz.m1.projet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
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
@DiscriminatorValue("Etudiant")
public class Etudiant extends Utilisateur{
    // @Id
    // @Column(unique = true, nullable = false)
    private String ine;

    @Column(nullable = false)
   // @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(nullable = false)
    private int groupeTd;

    @Column(nullable = false)
    private int groupeTp;

   //  @Enumerated(EnumType.STRING) // Indique que le rôle est stocké sous forme de chaîne
    // @Column(nullable = false)
     //private Role role;
}
