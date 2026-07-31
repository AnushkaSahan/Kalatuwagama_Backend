package com.kalatuwagama.service;

import com.kalatuwagama.dto.DonationInfoDto;
import java.util.List;
import java.util.UUID;

public interface DonationInfoService {
    DonationInfoDto create(DonationInfoDto dto);
    DonationInfoDto update(UUID id, DonationInfoDto dto);
    void delete(UUID id);
    DonationInfoDto getById(UUID id);
    List<DonationInfoDto> getAll();
}