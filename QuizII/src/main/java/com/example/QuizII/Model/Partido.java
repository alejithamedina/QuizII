package com.example.QuizII.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "partido")
@Data
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "estadio", nullable = false, length = 100)
    private String estadio;

    @Column(name = "goles_local", nullable = false)
    private Integer golesLocal;

    @Column(name = "goles_visita", nullable = false)
    private Integer golesVisita;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local", nullable = false, foreignKey = @ForeignKey(name = "fk_partido_equipo_local"))
    private Equipo equipoLocal;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visita", nullable = false, foreignKey = @ForeignKey(name = "fk_partido_equipo_visita"))
    private Equipo equipoVisita;
}
