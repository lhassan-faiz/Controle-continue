package demo.joueurs.entity;

import demo.joueurs.model.Equipe;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Joueur {
    @Id
    @GeneratedValue
    Long id ;
    String nom ;
    String position ;
    int salaire ;
    int nbr_bute ;
    Long ID_Equipe;

    @Transient
    Equipe equipe;
}
