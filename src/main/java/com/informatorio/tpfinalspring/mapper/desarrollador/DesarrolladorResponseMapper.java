package com.informatorio.tpfinalspring.mapper.desarrollador;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;

public interface DesarrolladorResponseMapper {

    DesarrolladorResponseDTO convertDesarrolladorToDesarrolladorResponseDTO(Desarrollador desarrollador);

}
