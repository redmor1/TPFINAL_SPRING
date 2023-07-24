package com.informatorio.tpfinalspring.model.dto.juego;

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
public class JuegoResponseDTO {
    private String titulo;
    private String descripcion;
    private String fechaLanzamiento;
}
