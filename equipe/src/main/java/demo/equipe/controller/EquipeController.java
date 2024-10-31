package demo.equipe.controller;

import demo.equipe.EquipeApplication;
import demo.equipe.entity.Equipe;
import demo.equipe.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Equipes")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }
    @PostMapping
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe equipe1 = equipeService.CreateEquipe(equipe);
        return ResponseEntity.ok(equipe1);
    }
    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipeList = equipeService.getAll();
        return ResponseEntity.ok(equipeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipe(@RequestParam Long id) {
        Equipe equipe = equipeService.getById(id);
        return ResponseEntity.ok(equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@RequestParam Long id) {}
}







