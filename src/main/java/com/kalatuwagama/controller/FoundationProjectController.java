package com.kalatuwagama.controller;

import com.kalatuwagama.dto.FoundationProjectDto;
import com.kalatuwagama.service.FoundationProjectService;
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
@RequestMapping("/api/foundation-projects")
@RequiredArgsConstructor
@Tag(name = "Foundation Projects", description = "Manage foundation projects")
public class FoundationProjectController {

    private final FoundationProjectService service;

    @GetMapping
    @Operation(summary = "Get all foundation projects")
    public ResponseEntity<List<FoundationProjectDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a foundation project by ID")
    public ResponseEntity<FoundationProjectDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Create a new foundation project")
    public ResponseEntity<FoundationProjectDto> create(@Valid @RequestBody FoundationProjectDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update an existing foundation project")
    public ResponseEntity<FoundationProjectDto> update(@PathVariable UUID id, @Valid @RequestBody FoundationProjectDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a foundation project")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}