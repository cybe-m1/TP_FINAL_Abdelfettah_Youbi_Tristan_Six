package com.example.demo.position;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Position {
    @Id
    private String nom;
    private String descriptif;
    private CoordonneesGPS coordonnees;

    public Position(String nom, String descriptif, CoordonneesGPS coordonnees){
        this.nom = nom;
        this.descriptif = descriptif;
        this.coordonnees = coordonnees;
    }
}
