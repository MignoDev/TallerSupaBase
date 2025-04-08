package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    @Query(value = "select * from Propietario where id_propietario = :id ", nativeQuery = true)
    Propietario buscarPropietario(@Param("id") Long id);
}
