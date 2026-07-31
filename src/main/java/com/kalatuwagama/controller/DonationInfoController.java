package com.kalatuwagama.controller;

import com.kalatuwagama.dto.DonationInfoDto;
import com.kalatuwagama.service.DonationInfoService;
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
@RequestMapping("/api/donation-info")
@RequiredArgsConstructor
@Tag(name = "Donation Info", description = "Manage donation information")
public class DonationInfoController {

    private final DonationInfoService service;

    @GetMapping
    @Operation(summary = "Get all donation info")
    public ResponseEntity<List<DonationInfoDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get donation info by ID")
    public ResponseEntity<DonationInfoDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Create new donation info")
    public ResponseEntity<DonationInfoDto> create(@Valid @RequestBody DonationInfoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update donation info")
    public ResponseEntity<DonationInfoDto> update(@PathVariable UUID id, @Valid @RequestBody DonationInfoDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete donation info")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}