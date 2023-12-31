package com.informatorio.tpfinalspring.controller.juego;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.exceptions.NotFoundException;
import com.informatorio.tpfinalspring.model.dto.desarrollador.DesarrolladorResponseDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoResponseDTO;
import com.informatorio.tpfinalspring.service.juego.JuegoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/juegos")
public class JuegoController {

    @Autowired
    JuegoService juegoService;

    @PostMapping
    public ResponseEntity createJuego(@RequestBody JuegoDTO juego) {
        JuegoResponseDTO juegoCreated = juegoService.createJuego(juego);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/juegos/" + juegoCreated.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{juegoId}")
    public JuegoResponseDTO getJuego(@PathVariable(value = "juegoId") Long juegoId) throws NotFoundException {
        return juegoService.getJuego(juegoId).orElseThrow(NotFoundException::new);
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
        return juegoService.getAllDesarrolladoresFromJuego(juegoId)
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{juegoId}/desarrolladores/{desarrolladorId}")
    public ResponseEntity putDesarrolladorInJuego(
            @PathVariable Long juegoId,
            @PathVariable Long desarrolladorId) throws NotFoundException {
        Optional<JuegoResponseDTO> juego = juegoService.putDesarrolladorInJuego(juegoId, desarrolladorId);

        if (juego.isEmpty()) {
            throw new NotFoundException();
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

    }

}
