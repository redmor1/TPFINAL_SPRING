package com.informatorio.tpfinalspring.controller.desarrollador;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorDTO;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.service.desarrollador.DesarrolladorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/desarrollador")
public class DesarrolladorController {

    @Autowired
    DesarrolladorService desarrolladorService;

    @PostMapping
    public ResponseEntity<Desarrollador> createDesarrollador(@RequestBody DesarrolladorDTO desarrolladorDTO) {
        Desarrollador desarrolladorCreated = desarrolladorService.createDesarrollador(desarrolladorDTO);

        return new ResponseEntity<Desarrollador>(desarrolladorCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public List<DesarrolladorResponseDTO> getAllDesarrolladores() {
        return desarrolladorService.getAllDesarrolladores();
    }

}
