package com.kalatuwagama.controller;

import com.kalatuwagama.dto.DahamPasalaInfoDto;
import com.kalatuwagama.service.DahamPasalaInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/daham-pasala-info")
@RequiredArgsConstructor
@Tag(name = "Daham Pasala Info", description = "Manage the Daham Pasala intro section (public site)")
public class DahamPasalaInfoController {

    private final DahamPasalaInfoService service;

    @GetMapping
    @Operation(summary = "Get all Daham Pasala info records")
    public ResponseEntity<List<DahamPasalaInfoDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Daham Pasala info by ID")
    public ResponseEntity<DahamPasalaInfoDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Create Daham Pasala info")
    public ResponseEntity<DahamPasalaInfoDto> create(@Valid @RequestBody DahamPasalaInfoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update Daham Pasala info")
    public ResponseEntity<DahamPasalaInfoDto> update(@PathVariable UUID id, @Valid @RequestBody DahamPasalaInfoDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Daham Pasala info")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}