package com.codecool.controller;

import com.codecool.dto.Weather.NewWeatherDto;
import com.codecool.dto.Weather.WeatherDto;
import com.codecool.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/{localizationId}")
    public ResponseEntity<List<WeatherDto>> getWeatherByLocalizationId(@PathVariable UUID localizationId) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getWeatherByLocalizationId(localizationId));
    }

    @PostMapping("/byName/{localizationName}")
    public ResponseEntity<List<WeatherDto>> getWeatherByLocalizationName(@PathVariable String localizationName) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getWeatherByLocalizationName(localizationName));
    }

    @PostMapping("/{localizationId}")
    public ResponseEntity<WeatherDto> createWeather(@Valid @RequestBody NewWeatherDto newWeatherDto
            , @PathVariable UUID localizationId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.createWeather(newWeatherDto,localizationId));
    }
}
