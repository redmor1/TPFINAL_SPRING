package com.informatorio.tpfinalspring.repository.juego;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.tpfinalspring.domain.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {

    public List<Juego> findByFechaLanzamientoBefore(LocalDate date);

    public List<Juego> findByFechaLanzamientoAfter(LocalDate date);
}
