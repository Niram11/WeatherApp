package com.codecool.service.mapper;

import com.codecool.dto.Weather.NewWeatherDto;
import com.codecool.dto.Weather.WeatherDto;
import com.codecool.repository.entity.Weather;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    Weather dtoToWeather(NewWeatherDto newWeatherDto);
    Weather dtoToWeather(UUID id);

    WeatherDto toDto(Weather weather);
}
