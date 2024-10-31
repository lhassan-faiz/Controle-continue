package demo.joueurs.Controller;

import demo.joueurs.entity.Joueur;
import demo.joueurs.services.JoueurService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/Joueurs")
@OpenAPIDefinition(
        info = @Info(
                title = "La gestion d'joueurs",
                description = "offre les opération pour gérer les joueurs",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8044/"
        )
)
public class JoueurController {
    @Autowired
     JoueurService joueurService;
     public JoueurController(JoueurService joueurService) {
         this.joueurService = joueurService;
     }
    @Operation(
            summary = "ajouter nouvel Joueur",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Joueur.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bien Ajouter",
                            content = @Content(mediaType = "applaction/json"
                                    , schema = @Schema(implementation = Joueur.class))),
                    @ApiResponse(responseCode = "400", description = "mal ajouter")
            })



     @PostMapping
     public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
         Joueur joueur1 = joueurService.CreateJoueur(joueur);
         return ResponseEntity.ok(joueur1);
     }

     @GetMapping
    public  ResponseEntity<List<Joueur>> GettallJoueur(){
         List<Joueur> joueurList = joueurService.GetAllJoueurs();
         return ResponseEntity.ok(joueurList);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
         Joueur joueur = joueurService.GetJoueurById(id);
         return ResponseEntity.ok(joueur);
     }

     @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @RequestBody Joueur joueur) {
         Joueur joueur1 = joueurService.UpdateJoueur(id, joueur);
         return ResponseEntity.ok(joueur1);
     }

     @DeleteMapping("/{id}")
    public void deleteJoueur(@PathVariable Long id) {
         joueurService.DeleteJoueur(id);
     }


    @GetMapping("/all-players-by-goals")
    public ResponseEntity<List<Joueur>> findPlayersByGoals() {
        List<Joueur> joueurList = joueurService.findAllPlayersByGoalsDesc();
        return ResponseEntity.ok(joueurList);
    }

    @GetMapping("/top-scorer")
    public ResponseEntity<Object[]> getTopScorer() {
        Optional<Object[]> topScorer = joueurService.getTopScorer();
        return topScorer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}







