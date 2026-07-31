package com.kalatuwagama.controller;

import com.kalatuwagama.dto.ContactMessageDto;
import com.kalatuwagama.service.ContactMessageService;
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
@RequestMapping("/api/contact-messages")
@RequiredArgsConstructor
@Tag(name = "Contact Messages", description = "Manage contact messages")
public class ContactMessageController {

    private final ContactMessageService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Get all contact messages (admin only)")
    public ResponseEntity<List<ContactMessageDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Get a contact message by ID (admin only)")
    public ResponseEntity<ContactMessageDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Submit a new contact message (public)")
    public ResponseEntity<ContactMessageDto> create(@Valid @RequestBody ContactMessageDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @Operation(summary = "Update a contact message (admin only)")
    public ResponseEntity<ContactMessageDto> update(@PathVariable UUID id, @Valid @RequestBody ContactMessageDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a contact message (admin only)")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}