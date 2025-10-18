package com.example.QuizII.Controller;

import com.example.QuizII.Model.Entrenador;
import com.example.QuizII.Service.EntrenadorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EntrenadorController {

    @Autowired
    public EntrenadorService entrenadorService;

    @PostMapping("/guardar")
    public ResponseEntity<Entrenador> guardar(@RequestBody Entrenador entrenador) {
        Entrenador creado = entrenadorService.guardar(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Entrenador>> listar() {
        List<Entrenador> Entrenador = entrenadorService.listar();
        return ResponseEntity.ok(Entrenador);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return entrenadorService.buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(Map.of("message", "El registro no existe", "id", id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entrenadorService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}


