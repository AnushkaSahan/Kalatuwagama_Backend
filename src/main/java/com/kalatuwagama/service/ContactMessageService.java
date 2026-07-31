package com.kalatuwagama.service;

import com.kalatuwagama.dto.ContactMessageDto;
import java.util.List;
import java.util.UUID;

public interface ContactMessageService {
    ContactMessageDto create(ContactMessageDto dto);
    // We may not allow update for contact messages, but we provide it anyway.
    ContactMessageDto update(UUID id, ContactMessageDto dto);
    void delete(UUID id);
    ContactMessageDto getById(UUID id);
    List<ContactMessageDto> getAll();
}