package com.informatorio.tpfinalspring.controller.tarea;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.informatorio.tpfinalspring.domain.Tarea;
import com.informatorio.tpfinalspring.domain.Tarea.Estado;
import com.informatorio.tpfinalspring.exceptions.NotFoundException;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaDTO;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaEstadoDTO;
import com.informatorio.tpfinalspring.model.dto.tarea.TareaResponseDTO;
import com.informatorio.tpfinalspring.service.tarea.TareaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @GetMapping
    public ResponseEntity<?> getAllTareas(
            @RequestParam(required = false) Estado estado,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaLimite,
            @RequestParam(required = false) Boolean fueraDePlazo) {

        // TODO: por ahora, para limitar la logica
        if (estado != null && fechaLimite != null) {
            return ResponseEntity.badRequest().body("Cannot provide both 'estado' and 'fechaLimite' query parameters");
        } else if (fueraDePlazo != null && fechaLimite != null) {
            return ResponseEntity.badRequest()
                    .body("Cannot provide both 'fueraDePlazo' and 'fechaLimite' query parameters");
        } else if (fueraDePlazo != null && estado != null) {
            return ResponseEntity.badRequest().body("Cannot provide both 'fueraDePlazo' and 'estado' query parameters");
        }

        List<Tarea> tareas = tareaService.getAllTareas(estado, fechaLimite, fueraDePlazo);
        return ResponseEntity.ok(tareas);
    }

    @PostMapping("/juego/{juegoId}/desarrollador/{desarrolladorId}")
    public ResponseEntity createTareaWithJuegoAndDesarrollador(@PathVariable Long juegoId,
            @PathVariable Long desarrolladorId, @RequestBody TareaDTO tareaDTO) throws NotFoundException {
        TareaResponseDTO tareaCreated = tareaService.createTareaWithJuegoAndDesarrollador(juegoId, desarrolladorId,
                tareaDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/tarea/" + tareaCreated.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @GetMapping("/{tareaId}")
    public TareaResponseDTO getTarea(@PathVariable(value = "tareaId") Long tareaId) throws NotFoundException {
        return tareaService.getTarea(tareaId).orElseThrow(NotFoundException::new);
    }

    @GetMapping("/desarrollador/{desarrolladorId}")
    public List<TareaResponseDTO> getAllTareasFromDesarrollador(@PathVariable Long desarrolladorId)
            throws NotFoundException {
        return tareaService.getAllTareasFromDesarrollador(desarrolladorId).orElseThrow(NotFoundException::new);
    }

    @GetMapping("/juego/{juegoId}")
    public List<TareaResponseDTO> getAllTareasFromJuego(@PathVariable Long juegoId) throws NotFoundException {

        return tareaService.getAllTareasFromJuego(juegoId).orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{tareaId}/estado")
    public ResponseEntity updateEstadoInTarea(@PathVariable Long tareaId, @RequestBody TareaEstadoDTO tareaEstadoDTO)
            throws NotFoundException {
        Optional<TareaResponseDTO> tarea = tareaService.updateEstadoInTarea(tareaId, tareaEstadoDTO.getEstado());
        if (tarea.isEmpty()) {
            throw new NotFoundException();
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

    }

}
