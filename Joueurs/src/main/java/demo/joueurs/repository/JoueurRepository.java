package demo.joueurs.repository;

import demo.joueurs.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {


//    pour chaque joueur
//    @Query("SELECT j.nom, j.nbr_bute FROM Joueur j")
//    List<Object[]> countGoalsByPlayer();

    // le meilleur buteur
    @Query("SELECT j.nom, j.nbr_bute FROM Joueur j ORDER BY j.nbr_bute DESC")
    Optional<Object[]> findTopScorer();

    //  buts marqués par l’équipe
    @Query("SELECT SUM(j.nbr_bute) FROM Joueur j")
    Long countTotalGoalsByTeam();

    @Query("SELECT j FROM Joueur j ORDER BY j.nbr_bute DESC")
    List<Joueur> findAllPlayersByGoalsDesc();

    @Query("update j.nbr_bute FROM Joueur j  ")
    int updateGoals();
}
