package com.informatorio.tpfinalspring.service.tarea.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.mapper.tarea.TareaMapper;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.repository.desarrollador.DesarrolladorRepository;
import com.informatorio.tpfinalspring.repository.juego.JuegoRepository;
import com.informatorio.tpfinalspring.repository.tarea.TareaRepository;
import com.informatorio.tpfinalspring.service.tarea.TareaService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TareaServiceImpl implements TareaService {

    @Autowired
    TareaRepository tareaRepository;
    JuegoRepository juegoRepository;
    DesarrolladorRepository desarrolladorRepository;
    TareaMapper tareaMapper;

    @Override
    public Tarea createTareaWithJuegoAndDesarrollador(Long juegoId, Long desarrolladorId, TareaDTO tareaDTO)
            throws NotFoundException {

        Tarea tarea = tareaMapper.convertTareaDTOtoTarea(tareaDTO);
        Optional<Juego> juegoSelected = juegoRepository.findById(juegoId);
        Optional<Desarrollador> desarrolladorSelected = desarrolladorRepository.findById(desarrolladorId);

        if (juegoSelected.isPresent() && desarrolladorSelected.isPresent()) {
            tarea.setDesarrolladorResponsable(desarrolladorSelected.get());
            tarea.setJuego(juegoSelected.get());
            tareaRepository.save(tarea);
            return tarea;
        } else {
            throw new NotFoundException();
        }

    }

}
