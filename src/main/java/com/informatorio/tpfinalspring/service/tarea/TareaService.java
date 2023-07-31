package com.informatorio.tpfinalspring.service.tarea;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.domain.Tarea.Estado;
import com.informatorio.tpfinalspring.exceptions.NotFoundException;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaResponseDTO;

public interface TareaService {

    public TareaResponseDTO createTareaWithJuegoAndDesarrollador(Long juegoId, Long desarrolladorId, TareaDTO tareaDTO)
            throws NotFoundException;

    public Optional<List<TareaResponseDTO>> getAllTareasFromDesarrollador(Long desarrolladorId);

    public void updateEstadoInTarea(Long tareaId, Estado estado);

    public List<Tarea> getAllTareas(Estado estado, LocalDate fechaLimite, Boolean fueraDePlazo);

    public Optional<List<TareaResponseDTO>> getAllTareasFromJuego(Long juegoId);

    public Optional<TareaResponseDTO> getTarea(Long tareaId);
}
