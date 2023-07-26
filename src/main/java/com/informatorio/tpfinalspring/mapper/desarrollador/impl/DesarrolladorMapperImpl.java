package com.informatorio.tpfinalspring.mapper.desarrollador.impl;

import org.springframework.stereotype.Component;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.mapper.desarrollador.DesarrolladorMapper;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorDTO;

@Component
public class DesarrolladorMapperImpl implements DesarrolladorMapper {

    @Override
    public Desarrollador convertDesarrolladorDTOToDesarrollador(DesarrolladorDTO desarrolladorDTO) {
        return Desarrollador.builder()
                .nombre(desarrolladorDTO.getNombre())
                .email(desarrolladorDTO.getEmail())
                .rol(desarrolladorDTO.getRol())
                .build();

    }

    @Override
    public DesarrolladorDTO convertDesarrolladorToDesarrolladorDTO(Desarrollador desarrollador) {
        return DesarrolladorDTO.builder()
                .nombre(desarrollador.getNombre())
                .email(desarrollador.getEmail())
                .rol(desarrollador.getRol())
                .build();
    }

}
