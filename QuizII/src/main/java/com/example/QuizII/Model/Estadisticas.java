package com.example.QuizII.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estadisticas")
@Data
public class Estadisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", nullable = false, foreignKey = @ForeignKey(name = "fk_estad_jugador"))
    private Jugador jugador;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partido", nullable = false, foreignKey = @ForeignKey(name = "fk_estad_partido"))
    private Partido partido;

    @Column(name = "minutos_jugados", nullable = false)
    private Integer minutosJugados;

    @Column(name = "goles", nullable = false)
    private Integer goles;

    @Column(name = "asistencias", nullable = false)
    private Integer asistencias;

    @Column(name = "tarjetas_amarillas", nullable = false)
    private Integer tarjetasAmarillas;

    @Column(name = "tarjetas_rojas", nullable = false)
    private Integer tarjetasRojas;

}


