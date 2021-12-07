package com.example.demo.creneau;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creneaux")
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

    @PostMapping("/search")
    public List<Creneau>  getCreneauByDate(@RequestBody CreneauDTO creneauDTO){
        return creneauService.getCreneauByDate(creneauDTO);
    }

    @PutMapping
    public Creneau modifyCreneau(@RequestBody Creneau creneau) {
        return creneauService.modifyCreneau(creneau);
    }

    @PostMapping
    public Creneau addCreneau(@RequestBody Creneau creneau) {
        return creneauService.addCreneau(creneau);
    }

    @DeleteMapping("/{idcreneau}")
    public String deleteCreneau(@PathVariable int idcreneau) {
        return creneauService.suppCreneau(idcreneau);
    }
}
