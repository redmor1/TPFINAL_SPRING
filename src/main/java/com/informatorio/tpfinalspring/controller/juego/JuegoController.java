package com.informatorio.tpfinalspring.controller.juego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.tpfinalspring.domain.Juego;
import com.informatorio.tpfinalspring.model.dto.juego.JuegoDTO;
import com.informatorio.tpfinalspring.service.juego.JuegoService;

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

}
