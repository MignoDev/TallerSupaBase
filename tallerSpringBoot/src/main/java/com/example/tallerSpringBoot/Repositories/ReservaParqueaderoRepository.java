package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.ReservaParqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaParqueaderoRepository extends JpaRepository<ReservaParqueadero, Long> {
}
