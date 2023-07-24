package com.informatorio.tpfinalspring.model.dto.juego;

import java.util.List;

import com.informatorio.tpfinalspring.domain.Desarrollador;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JuegoDTO {
    private String titulo;
    private String descripcion;
    private String fechaLanzamiento;
}
