package com.example.tallerSpringBoot.Repositories;

import com.example.tallerSpringBoot.Models.ZonaSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaSocialRepository extends JpaRepository<ZonaSocial, Long> {
}
