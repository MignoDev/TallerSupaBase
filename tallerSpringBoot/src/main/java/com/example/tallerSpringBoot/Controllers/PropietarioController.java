package com.example.tallerSpringBoot.Controllers;

import com.example.tallerSpringBoot.Models.Propietario;
import com.example.tallerSpringBoot.Models.ReservaParqueadero;
import com.example.tallerSpringBoot.Services.PropietarioService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    @Autowired
    public PropietarioService propietarioService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        try {
            List<Propietario> response = propietarioService.listar();
            if(response.isEmpty())
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener registros" + e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarId(@PathVariable long id)
    {
        try {
            Propietario result = propietarioService.buscarId(id);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ha ocurrido un error al obtener el registro: " + e.getMessage());
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear (@RequestBody Propietario propietario)
    {
        try {
            Propietario result = propietarioService.crear(propietario);
            return ResponseEntity.ok(result);
        } catch ( Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al crear el registro: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarId (@PathVariable long id)
    {
        try {
            propietarioService.eliminarId(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al eliminar el registro: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminar (@RequestBody Propietario propietario)
    {
        try {
            propietarioService.eliminar(propietario);
            return ResponseEntity.ok("Registro eliminado");
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al eliminar el registro: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar (@PathVariable long id, @RequestBody Propietario propietario)
    {
        try {
            Propietario result = propietarioService.actualizar(id, propietario);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al actualizar el registro: " + e.getMessage());
        }
    }

    @GetMapping("/buscarPropietario/{id}")
    public ResponseEntity<?> buscarPropietario (@PathVariable long id)
    {
        try {
            return ResponseEntity.ok(propietarioService.buscarPropietarioVisitantes(id));
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se ha generado un error en la peticion creada" + e.getMessage());
        }
    }

}
