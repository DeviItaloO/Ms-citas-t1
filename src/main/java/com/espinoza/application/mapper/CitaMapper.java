package com.espinoza.application.mapper;

import com.espinoza.domain.model.Cita;
import com.espinoza.domain.model.EstadoCita;
import com.espinoza.web.dto.CitaRequestDto;
import com.espinoza.web.dto.CitaResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {

    public Cita toEntity(CitaRequestDto dto) {
        return new Cita(
                null,
                dto.getFecha(),
                dto.getHora(),
                dto.getPaciente(),
                dto.getDoctorId(),
                EstadoCita.valueOf(dto.getEstado().toUpperCase()),
                dto.getNotas()
        );
    }

    public CitaResponseDto toDto(Cita entity) {
        return new CitaResponseDto(
                entity.getId(),
                entity.getFecha(),
                entity.getHora(),
                entity.getPaciente(),
                entity.getDoctorId(),
                entity.getEstado().name(),
                entity.getNotas()
        );
    }
}
