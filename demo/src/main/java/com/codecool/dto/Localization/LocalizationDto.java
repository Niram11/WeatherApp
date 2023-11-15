package com.codecool.dto.Localization;

import java.math.BigDecimal;
import java.util.UUID;

public record LocalizationDto(
        UUID id,
        String name,
        BigDecimal latitude,
        BigDecimal longitude
        ) {}
