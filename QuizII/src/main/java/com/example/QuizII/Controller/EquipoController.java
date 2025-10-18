package com.example.QuizII.Controller;

import com.example.QuizII.Model.Equipo;
import com.example.QuizII.Service.EquipoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EquipoController {

    @Autowired
    public EquipoService equipoService;

    @PostMapping("/guardar")
    public ResponseEntity<Equipo> guardar(@RequestBody Equipo equipo) {
        Equipo creado = equipoService.guardar(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Equipo>> listar() {
        List<Equipo> Equipo = equipoService.listar();
        return ResponseEntity.ok(Equipo);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        return equipoService.buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(Map.of("message", "El registro no existe", "id", id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        equipoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
