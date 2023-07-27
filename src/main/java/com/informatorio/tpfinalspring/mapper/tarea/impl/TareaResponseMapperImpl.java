package com.informatorio.tpfinalspring.mapper.tarea.impl;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.mapper.tarea.TareaResponseMapper;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaResponseDTO;

@Component
public class TareaResponseMapperImpl implements TareaResponseMapper {

    @Override
    public TareaResponseDTO convertTareaToTareaResponseDTO(Tarea tarea) {
        return TareaResponseDTO.builder()
                .id(tarea.getId())
                .descripcion(tarea.getDescripcion())
                .fechaLimite(tarea.getFechaLimite().format(DateTimeFormatter.ISO_LOCAL_DATE))
                .estado(tarea.getEstado())
                .build();
    }

}
