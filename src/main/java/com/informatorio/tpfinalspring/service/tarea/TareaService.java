package com.informatorio.tpfinalspring.service.tarea;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;

public interface TareaService {

    public Tarea createTareaWithJuegoAndDesarrollador(Long juegoId, Long desarrolladorId, TareaDTO tareaDTO)
            throws NotFoundException;
}
