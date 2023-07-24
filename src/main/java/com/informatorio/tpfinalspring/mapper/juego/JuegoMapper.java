package com.informatorio.tpfinalspring.mapper.juego;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;

public interface JuegoMapper {

    public Juego convertJuegoDTOToJuego(JuegoDTO juego);

    public JuegoDTO convertJuegoToJuegoDTO(Juego juego);
}
