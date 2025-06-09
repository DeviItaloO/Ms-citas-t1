package com.espinoza.application.service.interfaces;

import com.espinoza.web.dto.CitaRequestDto;
import com.espinoza.web.dto.CitaResponseDto;

import java.util.List;

public interface ICitaService {
    CitaResponseDto create(CitaRequestDto dto);
    List<CitaResponseDto> findAll();
    CitaResponseDto findById(Long id);
    CitaResponseDto update(Long id, CitaRequestDto dto);
    void delete(Long id);
}
