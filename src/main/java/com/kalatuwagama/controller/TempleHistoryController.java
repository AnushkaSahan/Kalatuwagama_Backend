package com.kalatuwagama.controller;

import com.kalatuwagama.dto.TempleHistoryDto;
import com.kalatuwagama.service.TempleHistoryService;
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
@RequestMapping("/api/temple-history")
@RequiredArgsConstructor
@Tag(name = "Temple History", description = "Manage historical records of the temple")
public class TempleHistoryController {

    private final TempleHistoryService service;

    @GetMapping
    @Operation(summary = "Get all temple history records")
    public ResponseEntity<List<TempleHistoryDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a temple history record by ID")
    public ResponseEntity<TempleHistoryDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Create a new temple history record")
    public ResponseEntity<TempleHistoryDto> create(@Valid @RequestBody TempleHistoryDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update an existing temple history record")
    public ResponseEntity<TempleHistoryDto> update(@PathVariable UUID id, @Valid @RequestBody TempleHistoryDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a temple history record")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}