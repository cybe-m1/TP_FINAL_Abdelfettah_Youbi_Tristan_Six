package com.example.demo.truck;

import com.example.demo.position.Position;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TruckService {
    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> getAllTruck() {
        return truckRepository.findAll();
    }

    public Truck getTruck(int idTruck) {
        return truckRepository.getById(idTruck);
    }

    public Truck addTruck(Truck newTruck) {
        Object[] truckGoingToPosition = truckRepository.findAll().stream().filter(lanbdatruck -> lanbdatruck.getId_position() == newTruck.getId_position()).toArray();
        if (truckGoingToPosition.length < 2) {
            if (truckRepository.existsById(newTruck.getId_truck())) {
                throw new IllegalArgumentException("Id " + newTruck.getId_truck() + " déja utilisé");
            } else {
                return truckRepository.save(newTruck);
            }
        } else {
            throw new IllegalArgumentException("Id: " + newTruck.getId_truck() + " Non trouvée dans la bdd");
        }
    }

    public Truck affectTruck(Truck truck) {
        if (truckRepository.existsById(truck.getId_truck())) {
            Object[] truckGoingToPosition = truckRepository.findAll().stream().filter(lanbdatruck -> lanbdatruck.getId_position() == truck.getId_position()).toArray();
            if (truckGoingToPosition.length < 2) {
                return truckRepository.save(truck);
            } else {
                throw new IllegalArgumentException("Trop de truck sont affécté à la même position");
            }
        } else {
            throw new IllegalArgumentException("Id: " + truck.getId_truck() + " Non trouvée dans la bdd");
        }
    }

    public String suppTruck(int id_truck) {
        if (truckRepository.existsById(id_truck)) {
            Truck truckToDelete = truckRepository.getById(id_truck);
            truckRepository.delete(truckToDelete);
            return "Le truck a était supprimer";
        } else {
            return"Id " + id_truck + " n'existe pas ou a deja était supprimer";
        }
    }
}
