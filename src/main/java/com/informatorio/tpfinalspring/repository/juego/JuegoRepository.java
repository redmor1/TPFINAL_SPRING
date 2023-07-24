package com.informatorio.tpfinalspring.repository.juego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.tpfinalspring.domain.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {

}
