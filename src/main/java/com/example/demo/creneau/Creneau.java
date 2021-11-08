package com.example.demo.creneau;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Creneau {
    @Id
    private String nom;
    private String descriptif;
    private Date date;

    public Creneau(String nom, String descriptif, Date date) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.date = date;
    }
}
