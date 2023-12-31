package com.informatorio.tpfinalspring.service.desarrollador;

import java.util.List;
import java.util.Optional;

import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorDTO;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;

public interface DesarrolladorService {

    public DesarrolladorResponseDTO createDesarrollador(DesarrolladorDTO desarrollador);

    public List<DesarrolladorResponseDTO> getAllDesarrolladores();

    public Optional<DesarrolladorResponseDTO> getDesarrollador(Long desarrolladorId);

}
