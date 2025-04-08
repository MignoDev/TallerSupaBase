package com.example.tallerSpringBoot.Services;

import com.example.tallerSpringBoot.Models.ReservaZona;
import com.example.tallerSpringBoot.Repositories.ReservaZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaZonaService {

    @Autowired
    public ReservaZonaRepository reservaZonaRepository;

    public List<ReservaZona> listar ()
    {
        return reservaZonaRepository.findAll();
    }

    public ReservaZona buscarId (long id)
    {
        return reservaZonaRepository.getReferenceById(id);
    }

    public ReservaZona crear (ReservaZona reservaZona)
    {
        return reservaZonaRepository.save(reservaZona);
    }

    public void eliminar (ReservaZona reservaZona)
    {
        if (!reservaZonaRepository.existsById(reservaZona.getIdReserva()))
        {
            throw new RuntimeException("La reserva no existe");
        }
        reservaZonaRepository.delete(reservaZona);
    }

    public void eliminarId (long id)
    {
        if (!reservaZonaRepository.existsById(id))
        {
            throw new RuntimeException("La reserva no existe");
        }
        reservaZonaRepository.deleteById(id);
    }

    public ReservaZona actualizar (long id, ReservaZona reservaZona)
    {
        if (!reservaZonaRepository.existsById(id))
        {
            throw new RuntimeException("La reserva no existe");
        }

        return reservaZonaRepository.save(reservaZona);
    }

}
