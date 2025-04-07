package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}
