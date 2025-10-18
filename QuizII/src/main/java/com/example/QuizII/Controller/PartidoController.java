package com.example.QuizII.Controller;


import com.example.QuizII.Model.Partido;
import com.example.QuizII.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class PartidoController {

    @Autowired
    public PartidoService partidoService;

    @PostMapping("/guardar")
    public ResponseEntity<Partido> guardar(@RequestBody Partido partido) {
        Partido creado = partidoService.guardar(partido);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Partido>> listar() {
        List<Partido> Partido = partidoService.listar();
        return ResponseEntity.ok(Partido);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return partidoService.buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(Map.of("message", "El registro no existe", "id", id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        partidoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
