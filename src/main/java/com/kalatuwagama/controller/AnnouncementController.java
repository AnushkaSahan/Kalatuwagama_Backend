package com.kalatuwagama.controller;

import com.kalatuwagama.dto.AnnouncementDto;
import com.kalatuwagama.service.AnnouncementService;
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
@RequestMapping("/api/announcements")
@RequiredArgsConstructor
@Tag(name = "Announcements", description = "Manage announcements")
public class AnnouncementController {

    private final AnnouncementService service;

    @GetMapping
    @Operation(summary = "Get all announcements")
    public ResponseEntity<List<AnnouncementDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an announcement by ID")
    public ResponseEntity<AnnouncementDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Create a new announcement")
    public ResponseEntity<AnnouncementDto> create(@Valid @RequestBody AnnouncementDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update an existing announcement")
    public ResponseEntity<AnnouncementDto> update(@PathVariable UUID id, @Valid @RequestBody AnnouncementDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete an announcement")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}