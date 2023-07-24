package com.informatorio.tpfinalspring.mapper.juego.impl;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.mapper.juego.JuegoResponseMapper;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;

@Component
public class JuegoResponseMapperImpl implements JuegoResponseMapper {

    @Override
    public JuegoResponseDTO convertJuegoToJuegoResponseDTO(Juego juego) {
        return JuegoResponseDTO.builder()
                .titulo(juego.getTitulo())
                .descripcion(juego.getDescripcion())
                .fechaLanzamiento(juego.getFechaLanzamiento().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .build();
    }

}
