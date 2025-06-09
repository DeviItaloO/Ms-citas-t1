package com.espinoza.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaRequestDto {
    private LocalDate fecha;
    private LocalTime hora;
    private String paciente;
    private Long doctorId;
    private String estado;
    private String notas;
}