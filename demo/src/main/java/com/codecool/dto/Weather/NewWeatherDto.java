package com.codecool.dto.Weather;

import java.time.LocalDateTime;

public record NewWeatherDto(
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
