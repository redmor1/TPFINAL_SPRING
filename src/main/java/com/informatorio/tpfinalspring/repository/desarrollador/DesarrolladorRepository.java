package com.informatorio.tpfinalspring.repository.desarrollador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.informatorio.tpfinalspring.domain.Desarrollador;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {

}
