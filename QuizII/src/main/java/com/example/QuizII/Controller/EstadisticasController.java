package com.example.QuizII.Controller;


import com.example.QuizII.Model.Estadisticas;
import com.example.QuizII.Service.EstadisticasService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class EstadisticasController {

    @Autowired
    public EstadisticasService estadisticasService;

    @PostMapping("/guardar")
    public ResponseEntity<Estadisticas> guardar(@RequestBody Estadisticas estadisticas) {
        Estadisticas creado = estadisticasService.guardar(estadisticas);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Estadisticas>> listar() {
        List<Estadisticas> Estadisticas = estadisticasService.listar();
        return ResponseEntity.ok(Estadisticas);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return estadisticasService.buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(Map.of("message", "El registro no existe", "id", id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadisticasService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
