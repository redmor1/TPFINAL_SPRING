package com.informatorio.tpfinalspring.service.desarrollador.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.mapper.desarrollador.DesarrolladorMapper;
import com.informatorio.tpfinalspring.mapper.desarrollador.DesarrolladorResponseMapper;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorDTO;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.repository.desarrollador.DesarrolladorRepository;
import com.informatorio.tpfinalspring.service.desarrollador.DesarrolladorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DesarrolladorServiceJPAImpl implements DesarrolladorService {

    @Autowired
    DesarrolladorMapper desarrolladorMapper;
    DesarrolladorResponseMapper desarrolladorResponseMapper;
    DesarrolladorRepository desarrolladorRepository;

    @Override
    public Desarrollador createDesarrollador(DesarrolladorDTO desarrollador) {

        Desarrollador desarrolladorCreated = desarrolladorMapper.convertDesarrolladorDTOToDesarrollador(desarrollador);

        desarrolladorRepository.save(desarrolladorCreated);

        return desarrolladorCreated;
    }

    @Override
    public List<DesarrolladorResponseDTO> getAllDesarrolladores() {
        List<Desarrollador> desarrolladores = desarrolladorRepository.findAll();

        List<DesarrolladorResponseDTO> desarrolladoresResponseDTOs = new ArrayList<>();

        for (Desarrollador desarrollador : desarrolladores) {
            DesarrolladorResponseDTO desarrolladorResponseDTO = desarrolladorResponseMapper
                    .convertDesarrolladorToDesarrolladorResponseDTO(desarrollador);
            desarrolladoresResponseDTOs.add(desarrolladorResponseDTO);
        }

        return desarrolladoresResponseDTOs;
    }

}
