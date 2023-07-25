package com.informatorio.tpfinalspring.model.dto.desarrollador;

import com.informatorio.tpfinalspring.domain.Desarrollador.Rol;

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
public class DesarrolladorResponseDTO {

    private Long id;
    private String nombre;
    private String email;
    private Rol rol;

}
