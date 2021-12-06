package com.example.demo.creneau;

import com.example.demo.position.Position;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Creneau")
public class CreneauController {
    private final CreneauService creneauService;

    public CreneauController(CreneauService creneauService) {
        this.creneauService = creneauService;
    }

    @GetMapping
    public List<Creneau> getListCreneau(){
        return creneauService.getAllCreneau();
    }

    @GetMapping("/{idCreneau}")
    public Creneau getCreneauById(@PathVariable int idCreneau){
        return creneauService.getCreneau(idCreneau);
    }

    @PostMapping
    public Creneau addCreneau(@RequestBody Creneau creneau) {
        return creneauService.addCreneau(creneau);
    }

    @DeleteMapping("/{id_creneau}")
    public String deleteCreneau(@PathVariable int id_creneau) {
        return creneauService.suppCreneau(id_creneau);
    }
}
