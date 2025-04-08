package com.example.tallerSpringBoot.Services;

import com.example.tallerSpringBoot.Models.ReservaParqueadero;
import com.example.tallerSpringBoot.Models.Visitante;
import com.example.tallerSpringBoot.Repositories.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitanteService {

    @Autowired
    public VisitanteRepository visitanteRepository;

    public List<Visitante> listar()
    {
        return visitanteRepository.findAll();
    }

    public Visitante buscarId( long id)
    {
        if (!visitanteRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        return visitanteRepository.getReferenceById(id);
    }

    public Visitante crear (Visitante visitante)
    {
        return visitanteRepository.save(visitante);
    }

    public void eliminar (Visitante visitante)
    {
        if (!visitanteRepository.existsById(visitante.getIdVisitante()))
        {
            throw new RuntimeException("El registro no existe");
        }
        visitanteRepository.delete(visitante);
    }

    public void eliminarId (long id)
    {
        if (!visitanteRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        visitanteRepository.deleteById(id);
    }

    public Visitante actualizar (long id, Visitante visitante)
    {
        if (!visitanteRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        return visitanteRepository.save(visitante);
    }
}
