package com.informatorio.tpfinalspring.repository.tarea;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.tpfinalspring.domain.Desarrollador;
import com.informatorio.tpfinalspring.domain.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    public List<Tarea> findByDesarrolladorResponsable(Desarrollador desarrolladorResponsable);
}
