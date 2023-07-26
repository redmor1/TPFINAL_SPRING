package com.informatorio.tpfinalspring.repository.tarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.tpfinalspring.domain.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
