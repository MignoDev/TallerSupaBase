package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
}
