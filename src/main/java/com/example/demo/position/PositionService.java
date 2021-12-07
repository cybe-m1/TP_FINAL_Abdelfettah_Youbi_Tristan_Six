package com.example.demo.position;

import com.example.demo.truck.Truck;
import com.example.demo.truck.TruckRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    private final PositionRepository positionRepository;
    private final TruckRepository truckRepository;

    public PositionService(PositionRepository positionRepository, TruckRepository truckRepository) {
        this.positionRepository = positionRepository;
        this.truckRepository = truckRepository;
    }

    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    public Position getPosition(int idPosition) {
        return positionRepository.getById(idPosition);
    }

    public List<Position> getPositionByName(String namePosition) {
        return positionRepository.findByNameContaining(namePosition);
    }

    public Position addPosition(Position position) {
        if (positionRepository.existsById(position.getId_position())) {
            throw new IllegalArgumentException("Id " + position.getId_position() + " déja utilisé");
        } else {
            if (GPSRule(position.getLongitude(), position.getLatitude())) {
                return positionRepository.save(position);
            } else {
                throw new IllegalArgumentException("Longitude ou latitude mauvaise");
            }
        }
    }

    public Position modifyPosition(Position position) {
        if (positionRepository.existsById(position.getId_position())) {
            if (GPSRule(position.getLongitude(), position.getLatitude())) {
                return positionRepository.save(position);
            } else {
                throw new IllegalArgumentException("Longitude ou latitude mauvaise");
            }
        } else {
            throw new IllegalArgumentException("Id " + position.getId_position() + " n'existe pas");
        }
    }

    public String suppPosition(int id_position) {
        if (positionRepository.existsById(id_position)) {
            Optional<Truck> truckGoingToPosition = truckRepository.findAll().stream().filter(truck -> truck.getId_position() == id_position).findFirst();
            if (truckGoingToPosition.isEmpty()) {
                Position positionToDelete = positionRepository.getById(id_position);
                positionRepository.delete(positionToDelete);
                return "La position a était supprimer";
            } else {
                return "Le truck " + truckGoingToPosition.get().getId_truck() + " va à cette position";
            }
        } else {
            return "La position possèdant l'id: " + id_position + " n'existe pas ou a deja était supprimer";
        }
    }

    private boolean GPSRule (double longitude, double latitude){
        if (longitude >= -180.00 && longitude <= 180.00 && latitude >= -90.00 && latitude <= 90.00 ) {
            return true;
        } else {
            return false;
        }
    }
}
