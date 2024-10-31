package demo.joueurs.services;

import demo.joueurs.Client.RestFeignEquipe;
import demo.joueurs.entity.Joueur;
import demo.joueurs.repository.JoueurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoueurService {
    private JoueurRepository joueurRepository;
    private RestFeignEquipe restFeignEquipe;

    public JoueurService(RestFeignEquipe restFeignEquipe, JoueurRepository joueurRepository) {
        this.restFeignEquipe = restFeignEquipe;
        this.joueurRepository = joueurRepository;
    }

    public Joueur CreateJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public List<Joueur> GetAllJoueurs() {
        List<Joueur> joueurs = joueurRepository.findAll();
        for (Joueur joueur : joueurs) {
            joueur.setEquipe(restFeignEquipe.getEquipe(joueur.getID_Equipe()));
        }
        return joueurs;

    }

    public Joueur GetJoueurById(long id) {
        Joueur joueur = joueurRepository.findById(id).orElse(null);
        joueur.setEquipe(restFeignEquipe.getEquipe(joueur.getID_Equipe()));
        return joueur;
    }


    public Joueur UpdateJoueur(Long id, Joueur joueur) {
        return joueurRepository.findById(id).map(joueur1 -> {
            joueur1.setNom(joueur.getNom());
            joueur1.setPosition(joueur.getPosition());
            joueur1.setSalaire(joueur.getSalaire());
            joueur1.setNbr_bute(joueur.getNbr_bute());
            joueur1.setID_Equipe(joueur.getID_Equipe());
            return joueurRepository.save(joueur1);
        }).orElse(null);
    }

    public List<Joueur> findAllPlayersByGoalsDesc() {
        return joueurRepository.findAllPlayersByGoalsDesc();
    }

    public Optional<Object[]> getTopScorer() {
        return joueurRepository.findTopScorer();
    }




    public void DeleteJoueur(long id) {joueurRepository.deleteById(id);}


}








