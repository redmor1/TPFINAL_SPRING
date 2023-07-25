package com.informatorio.tpfinalspring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Desarrollador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = false, nullable = false)
    private String nombre;

    @Column(length = 150, columnDefinition = "varchar(150)", updatable = true, nullable = false)
    private String email;

    @Column(updatable = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        DEV,
        QA,
        DEV_OPS
    }

}
