package com.informatorio.tpfinalspring.controller.juego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;
import com.informatorio.tpfinalspring.service.juego.JuegoService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/juego")
public class JuegoController {

    @Autowired
    JuegoService juegoService;

    @PostMapping
    public ResponseEntity<Juego> createJuego(@RequestBody JuegoDTO juego) {
        Juego juegoCreated = juegoService.createJuego(juego);

        return new ResponseEntity(juegoCreated, HttpStatus.CREATED);
    }

    @GetMapping(params = "status=developing")
    public List<JuegoResponseDTO> getAllDevelopingJuegos() {
        return juegoService.getAllDevelopingJuegos();
    }

    @GetMapping(params = "status=completed")
    public List<JuegoResponseDTO> getAllCompletedJuegos() {
        return juegoService.getAllCompletedJuegos();
    }

    @GetMapping("/{juegoId}/desarrolladores")
    public List<DesarrolladorResponseDTO> getAllDesarrolladoresFromJuego(@PathVariable(value = "juegoId") Long juegoId)
            throws NotFoundException {
        return juegoService.getAllDesarrolladoresFromJuego(juegoId).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{juegoId}/desarrolladores/{desarrolladorId}")
    public ResponseEntity putDesarrolladorInJuego(
            @PathVariable Long juegoId,
            @PathVariable Long desarrolladorId) {
        juegoService.putDesarrolladorInJuego(juegoId, desarrolladorId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}
