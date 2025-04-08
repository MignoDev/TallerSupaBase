package com.example.tallerSpringBoot.Controllers;

import com.example.tallerSpringBoot.Models.Propietario;
import com.example.tallerSpringBoot.Models.ReservaParqueadero;
import com.example.tallerSpringBoot.Services.ReservaParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resp")
public class ReservaParqueaderoController {

    @Autowired
    public ReservaParqueaderoService reservaParqueaderoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        try {
            List<ReservaParqueadero> response = reservaParqueaderoService.listar();
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
            ReservaParqueadero result = reservaParqueaderoService.buscarId(id);
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
    public ResponseEntity<?> crear (@RequestBody ReservaParqueadero reserva)
    {
        try {
            ReservaParqueadero result = reservaParqueaderoService.crear(reserva);
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
            reservaParqueaderoService.eliminarId(id);
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
    public ResponseEntity<?> eliminar (@RequestBody ReservaParqueadero reserva)
    {
        try {
            reservaParqueaderoService.eliminar(reserva);
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
    public ResponseEntity<?> actualizar (@PathVariable long id, @RequestBody ReservaParqueadero reserva)
    {
        try {
            ReservaParqueadero result = reservaParqueaderoService.actualizar(id, reserva);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al actualizar el registro: " + e.getMessage());
        }
    }


}
