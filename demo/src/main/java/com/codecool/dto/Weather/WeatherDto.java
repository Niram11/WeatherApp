package com.codecool.dto.Weather;

import java.time.LocalDateTime;
import java.util.UUID;

public record WeatherDto(
        UUID id,
        UUID locationId,
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
