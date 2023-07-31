package com.informatorio.tpfinalspring.controller.desarrollador;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.exceptions.NotFoundException;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorDTO;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.service.desarrollador.DesarrolladorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/desarrolladores")
public class DesarrolladorController {

    @Autowired
    DesarrolladorService desarrolladorService;

    @PostMapping
    public ResponseEntity createDesarrollador(@RequestBody DesarrolladorDTO desarrolladorDTO) {
        DesarrolladorResponseDTO desarrolladorCreated = desarrolladorService.createDesarrollador(desarrolladorDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/desarrolladores/" + desarrolladorCreated.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{desarrolladorId}")
    public DesarrolladorResponseDTO getDesarrollador(@PathVariable(value = "desarrolladorId") Long desarrolladorId)
            throws NotFoundException {
        return desarrolladorService.getDesarrollador(desarrolladorId).orElseThrow(NotFoundException::new);
    }

    @GetMapping
    public List<DesarrolladorResponseDTO> getAllDesarrolladores() {
        return desarrolladorService.getAllDesarrolladores();
    }

}
