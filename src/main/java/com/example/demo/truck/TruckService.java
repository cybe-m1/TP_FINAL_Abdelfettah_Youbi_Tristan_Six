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
        if (nbTruckGoingToPosition(newTruck.getId_position())) {
            if (truckRepository.existsById(newTruck.getId_truck())) {
                throw new IllegalArgumentException("Id " + newTruck.getId_truck() + " déja utilisé");
            } else {
                return truckRepository.save(newTruck);
            }
        } else {
            throw new IllegalArgumentException("Impossible de créé il y a trop de truck affecté a cette position");
        }
    }

    public Truck modifyTruck(Truck truck) {
        if (truckRepository.existsById(truck.getId_truck())) {
            if (nbTruckGoingToPosition(truck.getId_position())) {
                return truckRepository.save(truck);
            } else {
                throw new IllegalArgumentException("impossible de modifier il y a trop de trucks affecté à la même position");
            }
        } else {
            throw new IllegalArgumentException("Id: " + truck.getId_truck() + " Non trouvée dans la bdd");
        }
    }

    public Truck putPositionToTruck(int idTruck, int idPosition) {
        if (truckRepository.existsById(idTruck)) {
            if (nbTruckGoingToPosition(idPosition)) {
                Truck truckModifyPosition = truckRepository.getById(idTruck);
                truckModifyPosition.setId_position(idPosition);
                return truckRepository.save(truckModifyPosition);
            } else {
                throw new IllegalArgumentException("impossible de modifier il y a trop de trucks affecté à la même position");
            }
        } else {
            throw new IllegalArgumentException("Id: " + idTruck + " Non trouvée dans la bdd");
        }
    }

    public Truck putCreneauToTruck(int idTruck, int idCreneau) {
        if (truckRepository.existsById(idTruck)) {
            Truck truckModifyPosition = truckRepository.getById(idTruck);
            truckModifyPosition.setId_creneau(idCreneau);
            return truckRepository.save(truckModifyPosition);
        } else {
            throw new IllegalArgumentException("Id: " + idTruck + " Non trouvée dans la bdd");
        }
    }

    public String suppTruck(int idtruck) {
        if (truckRepository.existsById(idtruck)) {
            Truck truckToDelete = truckRepository.getById(idtruck);
            truckRepository.delete(truckToDelete);
            return "Le truck a était supprimer";
        } else {
            return"Id " + idtruck + " n'existe pas ou a deja était supprimer";
        }
    }

    private boolean nbTruckGoingToPosition(int idposition){
        Object[] truckGoingToPosition = truckRepository.findAll().stream().filter(lanbdatruck -> lanbdatruck.getId_position() == idposition).toArray();
        if (truckGoingToPosition.length < 2) {
            return true;
        } else {
            return false;
        }
    }
}
