package com.example.QuizII.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entrenador")
@Data
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "especialidad", nullable = false, length = 100)
    private String especialidad;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false, foreignKey = @ForeignKey(name = "fk_entrenador_equipo"))
    private Equipo equipo;
}


