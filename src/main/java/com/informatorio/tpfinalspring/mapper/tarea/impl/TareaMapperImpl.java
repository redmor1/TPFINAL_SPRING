package com.informatorio.tpfinalspring.mapper.tarea.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.mapper.tarea.TareaMapper;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaEstadoDTO;

@Component
public class TareaMapperImpl implements TareaMapper {

    public Tarea convertTareaDTOtoTarea(TareaDTO tareaDTO) {
        return Tarea.builder()
                .descripcion(tareaDTO.getDescripcion())
                .estado(tareaDTO.getEstado())
                .fechaLimite(LocalDate.parse(tareaDTO.getFechaLimite()))
                .build();
    }

    @Override
    public TareaDTO convertTareaToTareaDTO(Tarea tarea) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertTareaToTareaDTO'");
    }

}
