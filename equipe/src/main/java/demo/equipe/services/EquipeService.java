package demo.equipe.services;

import demo.equipe.entity.Equipe;
import demo.equipe.repository.RepositoryEquipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
     RepositoryEquipe repositoryEquipe;
     public EquipeService(RepositoryEquipe repositoryEquipe) {}

    public Equipe CreateEquipe(Equipe equipe) {return repositoryEquipe.save(equipe);}

    public List<Equipe> getAll() {return repositoryEquipe.findAll();}

    public Equipe getById(Long id) {return repositoryEquipe.getById(id);}

    public Equipe update(Long id, Equipe equipe) {
        return repositoryEquipe.findById(id).map(e -> {
            e.setCode(equipe.getCode());
            e.setLibelle(equipe.getLibelle());
            return repositoryEquipe.save(e);


        }).orElse(null);
    }
    public void delete(Long id){repositoryEquipe.deleteById(id);}
}

