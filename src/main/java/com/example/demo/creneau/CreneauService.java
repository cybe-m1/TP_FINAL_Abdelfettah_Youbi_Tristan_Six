package com.example.demo.creneau;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreneauService {
    private final CreneauRepository creneauRepository;

    public CreneauService(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }

    public List<Creneau> getAllCreneau() {
        return creneauRepository.findAll();
    }

    public Creneau getCreneau(int idCreneau) {
        return creneauRepository.getById(idCreneau);
    }

    public Creneau addCreneau(Creneau creneau) {
        if (creneauRepository.existsById(creneau.getId_creneau())) {
            throw new IllegalArgumentException("Id " + creneau.getId_creneau() + " déja utilisé");
        } else {
            return creneauRepository.save(creneau);
        }
    }

    public String suppCreneau(int id_creneau) {
        if (creneauRepository.existsById(id_creneau)) {
            Creneau creneauToDelete = creneauRepository.getById(id_creneau);
            creneauRepository.delete(creneauToDelete);
            return "Le creneau a était supprimer";
        } else {
            return "Id " + id_creneau + " n'existe pas ou a deja était supprimer";
        }
    }
}
