package com.espinoza.domain.repository;

import com.espinoza.domain.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitaRepository extends JpaRepository<Cita, Long> {
}
