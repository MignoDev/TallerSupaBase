package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    @Query(value = "select p, v  from propietario p inner join visitante v on v.id_propietario = p.id_propietario where p.id_propietario = :id ", nativeQuery = true)
    List<Object[]> buscarPropietarioVisitantes(@Param("id") Long id);
}
