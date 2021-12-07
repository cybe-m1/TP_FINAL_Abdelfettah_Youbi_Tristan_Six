package com.example.demo.creneau;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CreneauRepository extends JpaRepository<Creneau, Integer> {
    List<Creneau> findByDate(LocalDate date);
}
