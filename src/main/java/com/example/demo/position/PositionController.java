package com.example.demo.position;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) { this.positionService = positionService; }

    @GetMapping
    public List<Position> getAllPosition(){ return positionService.getAllPosition(); }

    @GetMapping("/{idPosition}")
    public Position gePosition(@PathVariable int idPosition){ return positionService.getPosition(idPosition); }

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
