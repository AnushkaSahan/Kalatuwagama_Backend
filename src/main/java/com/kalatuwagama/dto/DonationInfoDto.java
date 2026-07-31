package com.kalatuwagama.dto;

import jakarta.validation.constraints.NotBlank;

public record DonationInfoDto(
        String id,
        @NotBlank String bankName,
        @NotBlank String accountName,
        @NotBlank String accountNumber,
        String branch,
        String qrImage
) {}