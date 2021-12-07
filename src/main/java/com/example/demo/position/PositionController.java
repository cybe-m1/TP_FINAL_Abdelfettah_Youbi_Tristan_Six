package com.example.demo.position;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) { this.positionService = positionService; }

    @GetMapping
    public List<Position> getAllPosition(){ return positionService.getAllPosition(); }

    @GetMapping("/{idPosition}")
    public Position gePosition(@PathVariable int idPosition){ return positionService.getPosition(idPosition); }

    @GetMapping("/search/{namePosition}")
    public List<Position> getPositionByName(@PathVariable String namePosition){
        return positionService.getPositionByName(namePosition);
    }

    @PostMapping
    public Position addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @PutMapping
    public Position modifyPosition(@RequestBody Position position) {
        return positionService.modifyPosition(position);
    }

    @DeleteMapping("/{id_position}")
    public String deletePosition(@PathVariable int id_position) {
        return positionService.suppPosition(id_position);
    }
}
