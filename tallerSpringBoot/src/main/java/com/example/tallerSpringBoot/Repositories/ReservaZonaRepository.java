package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.ReservaZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaZonaRepository extends JpaRepository<ReservaZona, Long> {
}
