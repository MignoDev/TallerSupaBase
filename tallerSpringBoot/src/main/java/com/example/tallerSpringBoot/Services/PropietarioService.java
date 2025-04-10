package com.example.tallerSpringBoot.Services;

import com.example.tallerSpringBoot.Models.Propietario;
import com.example.tallerSpringBoot.Repositories.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {

    @Autowired
    public PropietarioRepository propietarioRepository;

    public List<Propietario> listar () {
        return propietarioRepository.findAll();
    }

    public Propietario buscarId(long id) {
        if (!propietarioRepository.existsById(id))
        {
            throw new RuntimeException("El propietario con el id " + id + " no existe");
        }
        return propietarioRepository.getReferenceById(id);
    }

    public Propietario crear(Propietario propietario)
    {
        return propietarioRepository.save(propietario);
    }

    public void eliminar (Propietario propietario)
    {
        if (!propietarioRepository.existsById(propietario.getIdPropietario()))
        {
            throw new RuntimeException("El propietario que se desea eliminar no existe");
        }
        propietarioRepository.delete(propietario);
    }

    public void eliminarId (long id)
    {
        if (!propietarioRepository.existsById(id))
        {
            throw new RuntimeException("El propietario que se desea eliminar no existe");
        }
        propietarioRepository.deleteById(id);
    }

    public Propietario actualizar (long id, Propietario propietario)
    {
        if (!propietarioRepository.existsById(id))
        {
            throw new RuntimeException("El propietario que se desea actualizar no existe");
        }
        return propietarioRepository.save(propietario);
    }

    public List<Object[]> buscarPropietarioVisitantes (long id)
    {
        return propietarioRepository.buscarPropietarioVisitantes(id);
    }

    public List<Object[]> buscarPropietariosParqueaderos (long id)
    {
        return propietarioRepository.buscarPropietarioParqueadero(id);
    }

    public List<Object[]> buscarPropietariosZonas (long id)
    {
        return propietarioRepository.buscarPropietarioZona(id);
    }

    public List<Object[]> buscarPropietariosVisitanteParqueadero (long id)
    {
        return propietarioRepository.buscarPropietarioParqueaderoZona(id);
    }
}
