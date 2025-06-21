package com.espinoza.web.controller;

import com.espinoza.application.service.interfaces.ICitaService;
import com.espinoza.web.dto.CitaRequestDto;
import com.espinoza.web.dto.CitaResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final ICitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaResponseDto>> getAllCitas(@AuthenticationPrincipal Jwt jwt) {
        System.out.println("JWT CLAIMS:");
        jwt.getClaims().forEach((k, v) -> System.out.println(k + " = " + v));
        List<CitaResponseDto> citas = citaService.findAll();
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDto> getCitaById(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        System.out.println("JWT CLAIMS:");
        jwt.getClaims().forEach((k, v) -> System.out.println(k + " = " + v));
        CitaResponseDto cita = citaService.findById(id);
        return ResponseEntity.ok(cita);
    }

    @PostMapping
    public ResponseEntity<CitaResponseDto> createCita(@RequestBody CitaRequestDto dto, @AuthenticationPrincipal Jwt jwt) {
        System.out.println("JWT CLAIMS:");
        jwt.getClaims().forEach((k, v) -> System.out.println(k + " = " + v));
        CitaResponseDto created = citaService.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaResponseDto> updateCita(@PathVariable Long id, @RequestBody CitaRequestDto dto, @AuthenticationPrincipal Jwt jwt) {
        System.out.println("JWT CLAIMS:");
        jwt.getClaims().forEach((k, v) -> System.out.println(k + " = " + v));
        CitaResponseDto updated = citaService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        System.out.println("JWT CLAIMS:");
        jwt.getClaims().forEach((k, v) -> System.out.println(k + " = " + v));
        citaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}