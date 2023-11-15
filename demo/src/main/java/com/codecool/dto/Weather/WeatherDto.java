package com.codecool.dto.Weather;

import com.codecool.repository.entity.Localization;

import java.time.LocalDateTime;
import java.util.UUID;

public record WeatherDto(
        UUID id,
        Localization localization,
        LocalDateTime timestamp,
        Double temperature,
        Double sensedTemperature,
        Integer humidity,
        Integer atmosphericPressure,
        Double windSpeed,
        Integer windDirection,
        Double devPoint
) {
}
