package com.kalatuwagama.controller;

import com.kalatuwagama.dto.GalleryDto;
import com.kalatuwagama.service.GalleryService;
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
@RequestMapping("/api/gallery")
@RequiredArgsConstructor
@Tag(name = "Gallery", description = "Manage gallery images")
public class GalleryController {

    private final GalleryService service;

    @GetMapping
    @Operation(summary = "Get all gallery items")
    public ResponseEntity<List<GalleryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a gallery item by ID")
    public ResponseEntity<GalleryDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Create a new gallery item")
    public ResponseEntity<GalleryDto> create(@Valid @RequestBody GalleryDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update an existing gallery item")
    public ResponseEntity<GalleryDto> update(@PathVariable UUID id, @Valid @RequestBody GalleryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a gallery item")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}