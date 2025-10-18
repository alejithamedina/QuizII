package com.example.QuizII.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "jugador")
@Data
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "posicion", nullable = false, length = 50)
    private String posicion;

    @Column(name = "dorsal", nullable = false)
    private Integer dorsal;

    @Column(name = "fecha_nac", nullable = false)
    private LocalDate fechaNac;

    @Column(name = "nacionalidad", nullable = false, length = 100)
    private String nacionalidad;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false, foreignKey = @ForeignKey(name = "fk_jugador_equipo"))
    private Equipo equipo;

}


