package com.informatorio.tpfinalspring.mapper.juego;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;

public interface JuegoResponseMapper {

    public JuegoResponseDTO convertJuegoToJuegoResponseDTO(Juego juego);
}
