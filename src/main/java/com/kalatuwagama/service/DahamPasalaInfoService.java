package com.kalatuwagama.service;

import com.kalatuwagama.dto.DahamPasalaInfoDto;
import java.util.List;
import java.util.UUID;

public interface DahamPasalaInfoService {
    DahamPasalaInfoDto create(DahamPasalaInfoDto dto);
    DahamPasalaInfoDto update(UUID id, DahamPasalaInfoDto dto);
    void delete(UUID id);
    DahamPasalaInfoDto getById(UUID id);
    List<DahamPasalaInfoDto> getAll();
}