package com.informatorio.tpfinalspring.controller.tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.service.tarea.TareaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @PostMapping("/juego/{juegoId}/desarrollador/{desarrolladorId}")
    public ResponseEntity<Tarea> createTareaWithJuegoAndDesarrollador(@PathVariable Long juegoId,
            @PathVariable Long desarrolladorId, @RequestBody TareaDTO tareaDTO) throws NotFoundException {
        Tarea tareaCreated = tareaService.createTareaWithJuegoAndDesarrollador(juegoId, desarrolladorId, tareaDTO);

        return new ResponseEntity(tareaCreated, HttpStatus.CREATED);

    }

}
