package com.example.QuizII.Controller;


import com.example.QuizII.Model.Jugador;
import com.example.QuizII.Service.JugadorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class JugadorController {

    @Autowired
    public JugadorService jugadorService;

    @PostMapping("/guardar")
    public ResponseEntity<Jugador> guardar(@RequestBody Jugador jugador) {
        Jugador creado = jugadorService.guardar(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Jugador>> listar() {
        List<Jugador> Jugador = jugadorService.listar();
        return ResponseEntity.ok(Jugador);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return jugadorService.buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(Map.of("message", "El registro no existe", "id", id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        jugadorService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
