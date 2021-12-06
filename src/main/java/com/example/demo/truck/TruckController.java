package com.example.demo.truck;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Truck")
public class TruckController {
    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public List<Truck> getAllCreneau(){
        return truckService.getAllTruck();
    }

    @GetMapping("/{idTruck}")
    public Truck getTruck(@PathVariable int idTruck){
        return truckService.getTruck(idTruck);
    }

    @PostMapping
    public Truck addTRuck(@RequestBody Truck truck) {
        return truckService.addTruck(truck);
    }

    @PutMapping
    public Truck affectTruck(@RequestBody Truck truck) {
        return truckService.affectTruck(truck);
    }

    @DeleteMapping("/{id_truck}")
    public String deletePosition(@PathVariable int id_truck) {
        return truckService.suppTruck(id_truck);
    }
}
