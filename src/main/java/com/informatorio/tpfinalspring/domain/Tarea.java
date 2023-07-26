package com.informatorio.tpfinalspring.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 600, columnDefinition = "varchar(600)", updatable = true, nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    @JsonBackReference
    private Juego juego;

    @ManyToOne
    @JoinColumn(name = "desarrollador_responsable_id")
    private Desarrollador desarrolladorResponsable;

    @Column(updatable = true, nullable = false)
    private LocalDate fechaLimite;

    @Column(updatable = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        PENDIENTE,
        EN_PROGRESO,
        COMPLETADA
    }
}
