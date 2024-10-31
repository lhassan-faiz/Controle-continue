package demo.joueurs.Client;

import demo.joueurs.model.Equipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "equipe",url = "http://localhost:8010/v1/Equipes")
public interface RestFeignEquipe {
    @GetMapping("/{id}")
    Equipe getEquipe(@PathVariable Long id);
}

