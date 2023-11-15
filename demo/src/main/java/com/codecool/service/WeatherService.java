package com.codecool.service;

import com.codecool.dto.Weather.NewWeatherDto;
import com.codecool.dto.Weather.WeatherDto;
import com.codecool.repository.LocalizationRepository;
import com.codecool.repository.WeatherRepository;
import com.codecool.repository.entity.Localization;
import com.codecool.repository.entity.Weather;
import com.codecool.service.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherMapper mapper;
    private final LocalizationRepository localizationRepository;

    public WeatherService(WeatherRepository weatherRepository, WeatherMapper mapper
            , LocalizationRepository localizationRepository) {
        this.weatherRepository = weatherRepository;
        this.mapper = mapper;
        this.localizationRepository = localizationRepository;
    }

    public List<WeatherDto> getWeatherByLocalizationId(UUID localizationId) {
        return weatherRepository.getWeatherByLocalizationId(localizationId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<WeatherDto> getWeatherByLocalizationName(String localizationName) {
        return weatherRepository.getWeatherByLocalizationName(localizationName)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public WeatherDto createWeather(NewWeatherDto newWeatherDto, UUID localizationId) {
        Localization localization = localizationRepository.findById(localizationId).get();
        Weather weather = mapper.dtoToWeather(newWeatherDto);
        weather.setLocalization(localization);
        weatherRepository.save(weather);
        return mapper.toDto(weather);
    }
}
