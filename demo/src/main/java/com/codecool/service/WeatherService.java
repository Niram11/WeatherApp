package com.codecool.service;

import com.codecool.dto.Weather.NewWeatherDto;
import com.codecool.dto.Weather.WeatherDto;
import com.codecool.repository.LocalizationRepository;
import com.codecool.repository.WeatherRepository;
import com.codecool.repository.entity.Localization;
import com.codecool.repository.entity.Weather;
import com.codecool.service.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public WeatherDto getLatestWeather(UUID localizationId) {
        return mapper.toDto(weatherRepository.getLatestWeather(localizationId));
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

    public List<WeatherDto> getWeatherByDateRange(UUID localizationId, LocalDateTime start, LocalDateTime end) {
        return weatherRepository.getWeatherByLocalizationAndDateRange(localizationId, start, end)
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

    public void deleteWeather(UUID id) {
        weatherRepository.delete(mapper.dtoToWeather(id));
    }
}
