package com.informatorio.tpfinalspring.model.dto.tarea;

import com.informatorio.tpfinalspring.domain.Tarea.Estado;

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
public class TareaDTO {
    private String descripcion;
    private String fechaLimite;
    private Estado estado;
}
