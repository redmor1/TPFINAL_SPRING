package com.informatorio.tpfinalspring.mapper.tarea;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaResponseDTO;

public interface TareaResponseMapper {

    public TareaResponseDTO convertTareaToTareaResponseDTO(Tarea tarea);

}
