package com.informatorio.tpfinalspring.mapper.desarrollador;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorDTO;

public interface DesarrolladorMapper {

    public Desarrollador convertDesarrolladorDTOToDesarrollador(DesarrolladorDTO desarrolladorDTO);

    public DesarrolladorDTO convertDesarrolladorToDesarrolladorDTO(Desarrollador desarrollador);

}
