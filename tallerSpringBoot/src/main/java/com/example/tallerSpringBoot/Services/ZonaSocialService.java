package com.example.tallerSpringBoot.Services;

import com.example.tallerSpringBoot.Models.ReservaParqueadero;
import com.example.tallerSpringBoot.Models.ZonaSocial;
import com.example.tallerSpringBoot.Repositories.ZonaSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaSocialService {

    @Autowired
    public ZonaSocialRepository zonaSocialRepository;

    public List<ZonaSocial> listar()
    {
        return zonaSocialRepository.findAll();
    }

    public ZonaSocial buscarId( long id)
    {
        if (!zonaSocialRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        return zonaSocialRepository.getReferenceById(id);
    }

    public ZonaSocial crear (ZonaSocial zonaSocial)
    {
        return zonaSocialRepository.save(zonaSocial);
    }

    public void eliminar (ZonaSocial zonaSocial)
    {
        if (!zonaSocialRepository.existsById(zonaSocial.getIdZona()))
        {
            throw new RuntimeException("El registro no existe");
        }
        zonaSocialRepository.delete(zonaSocial);
    }

    public void eliminarId (long id)
    {
        if (!zonaSocialRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        zonaSocialRepository.deleteById(id);
    }

    public ZonaSocial actualizar (long id, ZonaSocial zonaSocial)
    {
        if (!zonaSocialRepository.existsById(id))
        {
            throw new RuntimeException("El registro no existe");
        }
        return zonaSocialRepository.save(zonaSocial);
    }
}
