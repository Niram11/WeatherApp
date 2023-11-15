package com.codecool.dto.Localization;

import java.math.BigDecimal;

public record NewLocalizationDto(
        String name,
        BigDecimal latitude,
        BigDecimal longitude
) {}
