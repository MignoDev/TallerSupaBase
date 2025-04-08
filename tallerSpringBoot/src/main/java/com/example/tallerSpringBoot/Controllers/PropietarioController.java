package com.example.tallerSpringBoot.Controllers;

import com.example.tallerSpringBoot.Models.Propietario;
import com.example.tallerSpringBoot.Services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    @Autowired
    public PropietarioService propietarioService;

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

}
