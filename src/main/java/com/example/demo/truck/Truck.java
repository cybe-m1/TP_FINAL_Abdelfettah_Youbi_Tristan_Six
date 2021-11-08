package com.example.demo.truck;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Truck {
    @Id
    private int id;
    private String nom;
    private String descriptif;

    public Truck(int id, String nom, String descriptif){
        this.id = id;
        this.nom = nom;
        this.descriptif = descriptif;
    }
}
