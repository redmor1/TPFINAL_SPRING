package com.informatorio.tpfinalspring.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String titulo;

    @Column(length = 200, columnDefinition = "varchar(200)", updatable = true, nullable = false)
    private String descripcion;

    @OneToMany
    @JoinColumn(name = "juego_id")
    private List<Desarrollador> desarrolladores;

    @OneToMany(mappedBy = "juego")
    private List<Tarea> tareas = new ArrayList<>();

    @Column(length = 200, updatable = true, nullable = false)
    private LocalDate fechaLanzamiento;
}
