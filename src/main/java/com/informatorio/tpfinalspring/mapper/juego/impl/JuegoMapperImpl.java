package com.informatorio.tpfinalspring.mapper.juego.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.mapper.juego.JuegoMapper;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;

@Component
public class JuegoMapperImpl implements JuegoMapper {

    @Override
    public Juego convertJuegoDTOToJuego(JuegoDTO juegoDTO) {
        return Juego.builder()
                .titulo(juegoDTO.getTitulo())
                .descripcion(juegoDTO.getDescripcion())
                .fechaLanzamiento(LocalDate.parse(juegoDTO.getFechaLanzamiento()))
                .desarrolladores(new ArrayList<>())
                .tareas(new ArrayList<>())
                .build();

    }

    @Override
    public JuegoDTO convertJuegoToJuegoDTO(Juego juego) {
        return JuegoDTO.builder()
                .titulo(juego.getTitulo())
                .descripcion(juego.getDescripcion())
                .fechaLanzamiento(juego.getFechaLanzamiento().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .build();
    }

}
