package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.Propietario;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    @Query("SELECT p, v FROM Propietario p JOIN p.visitantes v WHERE p.idPropietario = :id")
    List<Object[]> buscarPropietarioVisitantes(@Param("id") Long id);

    @Query("SELECT p, r FROM Propietario p JOIN p.reservaParqueaderos r WHERE p.idPropietario = :id")
    List<Object[]> buscarPropietarioParqueadero(@Param("id") Long id);

    @Query("SELECT p, z FROM Propietario p JOIN p.reservaZonas z WHERE p.idPropietario = :id")
    List<Object[]> buscarPropietarioZona(@Param("id") Long id);

    @Query("SELECT p, v, z FROM Propietario p JOIN p.visitantes v JOIN p.reservaParqueaderos z WHERE p.idPropietario = :id")
    List<Object[]> buscarPropietarioParqueaderoZona(@Param("id") Long id);
}
