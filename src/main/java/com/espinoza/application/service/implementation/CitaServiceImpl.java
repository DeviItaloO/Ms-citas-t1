package com.espinoza.application.service.implementation;

import com.espinoza.application.mapper.CitaMapper;
import com.espinoza.application.service.interfaces.ICitaService;
import com.espinoza.domain.model.Cita;
import com.espinoza.domain.model.EstadoCita;
import com.espinoza.domain.repository.ICitaRepository;
import com.espinoza.web.dto.CitaRequestDto;
import com.espinoza.web.dto.CitaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements ICitaService {

    private final ICitaRepository citaRepository;
    private final CitaMapper citaMapper;

    @Override
    public CitaResponseDto create(CitaRequestDto dto) {
        Cita cita = citaMapper.toEntity(dto);
        Cita saved = citaRepository.save(cita);
        return citaMapper.toDto(saved);
    }

    @Override
    public List<CitaResponseDto> findAll() {
        return citaRepository.findAll().stream()
                .map(citaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CitaResponseDto findById(Long id) {
        return citaRepository.findById(id)
                .map(citaMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
    }

    @Override
    public CitaResponseDto update(Long id, CitaRequestDto dto) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

        cita.setFecha(dto.getFecha());
        cita.setHora(dto.getHora());
        cita.setPaciente(dto.getPaciente());
        cita.setDoctorId(dto.getDoctorId());
        cita.setEstado(EstadoCita.valueOf(dto.getEstado().toUpperCase()));
        cita.setNotas(dto.getNotas());

        Cita updated = citaRepository.save(cita);
        return citaMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
        citaRepository.delete(cita);
    }
}