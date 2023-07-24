package com.informatorio.tpfinalspring.service.juego.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.mapper.juego.JuegoMapper;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.repository.juego.JuegoRepository;
import com.informatorio.tpfinalspring.service.juego.JuegoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JuegoServiceJPAImpl implements JuegoService {

    @Autowired
    JuegoMapper juegoMapper;
    JuegoRepository juegoRepository;

    @Override
    public Juego createJuego(JuegoDTO juego) {
        Juego juegoCreated = juegoMapper.convertJuegoDTOToJuego(juego);
        juegoRepository.save(juegoCreated);
        return juegoCreated;
    }

}
