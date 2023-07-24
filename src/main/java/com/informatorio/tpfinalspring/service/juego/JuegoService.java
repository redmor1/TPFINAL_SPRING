package com.informatorio.tpfinalspring.service.juego;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;

public interface JuegoService {

    public Juego createJuego(JuegoDTO juego);
}
