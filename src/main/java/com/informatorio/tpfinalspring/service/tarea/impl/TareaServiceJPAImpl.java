package com.informatorio.tpfinalspring.service.tarea.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.domain.Tarea.Estado;
import com.informatorio.tpfinalspring.exceptions.NotFoundException;
import com.informatorio.tpfinalspring.mapper.tarea.TareaMapper;
import com.informatorio.tpfinalspring.mapper.tarea.TareaResponseMapper;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaResponseDTO;
import com.informatorio.tpfinalspring.repository.desarrollador.DesarrolladorRepository;
import com.informatorio.tpfinalspring.repository.juego.JuegoRepository;
import com.informatorio.tpfinalspring.repository.tarea.TareaRepository;
import com.informatorio.tpfinalspring.service.tarea.TareaService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TareaServiceJPAImpl implements TareaService {

    @Autowired
    TareaRepository tareaRepository;
    JuegoRepository juegoRepository;
    DesarrolladorRepository desarrolladorRepository;
    TareaMapper tareaMapper;
    TareaResponseMapper tareaResponseMapper;

    @Override
    public TareaResponseDTO createTareaWithJuegoAndDesarrollador(Long juegoId, Long desarrolladorId, TareaDTO tareaDTO)
            throws NotFoundException {

        Tarea tarea = tareaMapper.convertTareaDTOtoTarea(tareaDTO);
        Optional<Juego> juegoSelected = juegoRepository.findById(juegoId);
        Optional<Desarrollador> desarrolladorSelected = desarrolladorRepository.findById(desarrolladorId);

        if (juegoSelected.isPresent() && desarrolladorSelected.isPresent()) {
            tarea.setDesarrolladorResponsable(desarrolladorSelected.get());
            tarea.setJuego(juegoSelected.get());
            tareaRepository.save(tarea);
            return tareaResponseMapper.convertTareaToTareaResponseDTO(tarea);
        } else {
            throw new NotFoundException();
        }

    }

    @Override
    public Optional<List<TareaResponseDTO>> getAllTareasFromDesarrollador(Long desarrolladorId) {
        Optional<Desarrollador> desarrolladorSelected = desarrolladorRepository.findById(desarrolladorId);

        List<TareaResponseDTO> tareasResponseDTOs = new ArrayList<>();

        if (desarrolladorSelected.isPresent()) {

            List<Tarea> tareas = tareaRepository.findByDesarrolladorResponsable(desarrolladorSelected.get());
            for (Tarea tarea : tareas) {
                TareaResponseDTO tareaConverted = tareaResponseMapper.convertTareaToTareaResponseDTO(tarea);
                tareasResponseDTOs.add(tareaConverted);
            }
            return Optional.of(tareasResponseDTOs);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void updateEstadoInTarea(Long tareaId, Estado estado) {
        // TODO: revisar la logica aca y ver q hay q devolver
        Optional<Tarea> tareaSelected = tareaRepository.findById(tareaId);
        if (tareaSelected.isPresent()) {
            tareaSelected.get().setEstado(estado);
            tareaRepository.save(tareaSelected.get());
        } else {
            throw new EntityNotFoundException("Tarea with ID " + tareaId + " not found");
        }
    }

    @Override
    public List<Tarea> getAllTareas(Estado estado, LocalDate fechaLimite, Boolean fueraDelPlazo) {

        List<Tarea> tareas;

        if (fueraDelPlazo != null && fueraDelPlazo) {

            List<Tarea> tareasPendientes = tareaRepository.findByEstadoAndFechaLimiteBefore(Estado.PENDIENTE,
                    LocalDate.now());
            List<Tarea> tareasEnProgreso = tareaRepository.findByEstadoAndFechaLimiteBefore(Estado.EN_PROGRESO,
                    LocalDate.now());

            List<Tarea> combinedTareas = new ArrayList<>();
            combinedTareas.addAll(tareasPendientes);
            combinedTareas.addAll(tareasEnProgreso);

            return combinedTareas;
        } else if (estado != null) {
            tareas = tareaRepository.findByEstado(estado);
            return tareas;
        } else if (fechaLimite != null) {
            tareas = tareaRepository.findByFechaLimite(fechaLimite);
            return tareas;
        } else {
            tareas = tareaRepository.findAll();
            return tareas;
        }
    }

    @Override
    public Optional<List<TareaResponseDTO>> getAllTareasFromJuego(Long juegoId) {
        Optional<Juego> juegoSelected = juegoRepository.findById(juegoId);

        List<TareaResponseDTO> tareaResponseDTOs = new ArrayList<>();

        if (juegoSelected.isPresent()) {
            List<Tarea> tareas = tareaRepository.findByJuego(juegoSelected.get());

            for (Tarea tarea : tareas) {
                TareaResponseDTO tareaConverted = tareaResponseMapper.convertTareaToTareaResponseDTO(tarea);
                tareaResponseDTOs.add(tareaConverted);
            }

            return Optional.of(tareaResponseDTOs);

        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TareaResponseDTO> getTarea(Long tareaId) {
        Optional<Tarea> tareaSelected = tareaRepository.findById(tareaId);
        if (tareaSelected.isPresent()) {
            return Optional.of(tareaResponseMapper.convertTareaToTareaResponseDTO(tareaSelected.get()));
        } else {
            return Optional.empty();
        }
    }

}
