package com.informatorio.tpfinalspring.service.tarea;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaResponseDTO;

public interface TareaService {

    public Tarea createTareaWithJuegoAndDesarrollador(Long juegoId, Long desarrolladorId, TareaDTO tareaDTO)
            throws NotFoundException;

    public Optional<List<TareaResponseDTO>> getAllTareasFromDesarrollador(Long desarrolladorId);
}
