package com.example.tallerSpringBoot.Services;

import com.example.tallerSpringBoot.Models.ReservaParqueadero;
import com.example.tallerSpringBoot.Repositories.ReservaParqueaderoRepository;
import com.example.tallerSpringBoot.Repositories.ReservaZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaParqueaderoService {

    @Autowired
    public ReservaParqueaderoRepository reservaParqueaderoRepository;

    public List<ReservaParqueadero> listar()
    {
        return reservaParqueaderoRepository.findAll();
    }

    public ReservaParqueadero buscarId( long id)
    {
        if (!reservaParqueaderoRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        return reservaParqueaderoRepository.getReferenceById(id);
    }

    public ReservaParqueadero guardar (ReservaParqueadero reservaParqueadero)
    {
        return reservaParqueaderoRepository.save(reservaParqueadero);
    }

    public void eliminar (ReservaParqueadero reservaParqueadero)
    {
        if (!reservaParqueaderoRepository.existsById(reservaParqueadero.getIdReserva()))
        {
            throw new RuntimeException("El registro no existe");
        }
        reservaParqueaderoRepository.delete(reservaParqueadero);
    }

    public void eliminarId (long id)
    {
        if (!reservaParqueaderoRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        reservaParqueaderoRepository.deleteById(id);
    }

    public ReservaParqueadero actualizar (ReservaParqueadero reservaParqueadero)
    {
        if (!reservaParqueaderoRepository.existsById(reservaParqueadero.getIdReserva()))
        {
            throw new RuntimeException("El registro no existe");
        }
        return reservaParqueaderoRepository.save(reservaParqueadero);
    }
}
