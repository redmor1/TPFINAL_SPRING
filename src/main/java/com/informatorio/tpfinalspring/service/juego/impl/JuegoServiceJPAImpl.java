package com.informatorio.tpfinalspring.service.juego.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.mapper.desarrollador.DesarrolladorResponseMapper;
import com.informatorio.tpfinalspring.mapper.juego.JuegoMapper;
import com.informatorio.tpfinalspring.mapper.juego.JuegoResponseMapper;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;
import com.informatorio.tpfinalspring.repository.desarrollador.DesarrolladorRepository;
import com.informatorio.tpfinalspring.repository.juego.JuegoRepository;
import com.informatorio.tpfinalspring.service.juego.JuegoService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JuegoServiceJPAImpl implements JuegoService {

    @Autowired
    JuegoMapper juegoMapper;
    JuegoRepository juegoRepository;
    JuegoResponseMapper juegoResponseMapper;
    DesarrolladorRepository desarrolladorRepository;
    DesarrolladorResponseMapper desarrolladorResponseMapper;

    @Override
    public Juego createJuego(JuegoDTO juego) {
        Juego juegoCreated = juegoMapper.convertJuegoDTOToJuego(juego);
        juegoRepository.save(juegoCreated);
        return juegoCreated;
    }

    @Override
    public List<JuegoResponseDTO> getAllCompletedJuegos() {
        List<Juego> completedJuegos = juegoRepository.findByFechaLanzamientoLessThanEqual(LocalDate.now());

        List<JuegoResponseDTO> completedJuegosDTOs = new ArrayList<>();

        for (Juego juego : completedJuegos) {
            JuegoResponseDTO juegoDTO = juegoResponseMapper.convertJuegoToJuegoResponseDTO(juego);
            completedJuegosDTOs.add(juegoDTO);
        }

        return completedJuegosDTOs;
    }

    @Override
    public List<JuegoResponseDTO> getAllDevelopingJuegos() {
        List<Juego> developingJuegos = juegoRepository.findByFechaLanzamientoAfter(LocalDate.now());

        List<JuegoResponseDTO> developingJuegosDTOs = new ArrayList<>();

        for (Juego juego : developingJuegos) {
            JuegoResponseDTO juegoDTO = juegoResponseMapper.convertJuegoToJuegoResponseDTO(juego);
            developingJuegosDTOs.add(juegoDTO);
        }

        return developingJuegosDTOs;
    }

    @Override
    public Optional<List<DesarrolladorResponseDTO>> getAllDesarrolladoresFromJuego(Long juegoId) {
        Optional<Juego> juego = juegoRepository.findById(juegoId);

        if (juego.isPresent()) {
            List<Desarrollador> desarrolladores = juego.get().getDesarrolladores();
            List<DesarrolladorResponseDTO> desarrolladoresDTOs = new ArrayList<>();
            for (Desarrollador desarrollador : desarrolladores) {
                DesarrolladorResponseDTO desarrolladorResponseDTO = desarrolladorResponseMapper
                        .convertDesarrolladorToDesarrolladorResponseDTO(desarrollador);
                desarrolladoresDTOs.add(desarrolladorResponseDTO);
            }
            return Optional.of(desarrolladoresDTOs);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void putDesarrolladorInJuego(Long juegoId, Long desarrolladorId) {
        Optional<Juego> juegoSelected = juegoRepository.findById(juegoId);
        Optional<Desarrollador> desarrolladorSelected = desarrolladorRepository.findById(desarrolladorId);
        // TODO: revisar la logica aca y ver q devolver
        if (juegoSelected.isPresent() && desarrolladorSelected.isPresent()) {
            if (!juegoSelected.get().getDesarrolladores().contains(desarrolladorSelected.get()))
                juegoSelected.get().getDesarrolladores().add(desarrolladorSelected.get());
            juegoRepository.save(juegoSelected.get());
        } else {
            if (!juegoSelected.isPresent()) {
                throw new EntityNotFoundException("Juego with ID " + juegoId + " not found");
            } else {
                throw new EntityNotFoundException("Desarrollador with ID " + desarrolladorId + " not found");
            }
        }

    }

}
