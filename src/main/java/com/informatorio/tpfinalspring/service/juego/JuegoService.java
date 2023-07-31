package com.informatorio.tpfinalspring.service.juego;

import java.util.List;
import java.util.Optional;

import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;

public interface JuegoService {

    public JuegoResponseDTO createJuego(JuegoDTO juego);

    public List<JuegoResponseDTO> getAllDevelopingJuegos();

    public List<JuegoResponseDTO> getAllCompletedJuegos();

    public Optional<List<DesarrolladorResponseDTO>> getAllDesarrolladoresFromJuego(Long juegoId);

    public Optional<JuegoResponseDTO> putDesarrolladorInJuego(Long juegoId, Long desarrolladorId);

    public Optional<JuegoResponseDTO> getJuego(Long juegoId);
}
