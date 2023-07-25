package com.informatorio.tpfinalspring.mapper.desarrollador.impl;

import org.springframework.stereotype.Component;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.mapper.desarrollador.DesarrolladorResponseMapper;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;

@Component
public class DesarrolladorResponseMapperImpl implements DesarrolladorResponseMapper {

    @Override
    public DesarrolladorResponseDTO convertDesarrolladorToDesarrolladorResponseDTO(Desarrollador desarrollador) {
        return DesarrolladorResponseDTO.builder()
                .id(desarrollador.getId())
                .nombre(desarrollador.getNombre())
                .email(desarrollador.getEmail())
                .rol(desarrollador.getRol())
                .build();
    }

}
