package demo.equipe.repository;

import demo.equipe.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryEquipe extends JpaRepository<Equipe, Long> {

}
