package com.informatorio.tpfinalspring.mapper.tarea;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;

public interface TareaMapper {
    public Tarea convertTareaDTOtoTarea(TareaDTO tareaDTO);

    public TareaDTO convertTareaToTareaDTO(Tarea tarea);
}
