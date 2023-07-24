package com.informatorio.tpfinalspring.service.juego;

import java.util.List;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;

public interface JuegoService {

    public Juego createJuego(JuegoDTO juego);

    public List<JuegoResponseDTO> getAllCompletedJuegos();
}
