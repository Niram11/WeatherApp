package com.codecool.controller;

import com.codecool.dto.Weather.NewWeatherDto;
import com.codecool.dto.Weather.WeatherDto;
import com.codecool.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{localizationId}")
    public ResponseEntity<List<WeatherDto>> getWeatherByLocalizationId(@PathVariable UUID localizationId) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getWeatherByLocalizationId(localizationId));
    }

    @GetMapping("/byName/{localizationName}")
    public ResponseEntity<List<WeatherDto>> getWeatherByLocalizationName(@PathVariable String localizationName) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getWeatherByLocalizationName(localizationName));
    }

    @GetMapping("/{localizationId}/latest")
    public ResponseEntity<WeatherDto> getLatestWeather(@PathVariable UUID localizationId) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getLatestWeather(localizationId));
    }


    @GetMapping("/{localizationId}/range")
    public ResponseEntity<List<WeatherDto>> getWeatherByDateRange(@PathVariable UUID localizationId
            , @RequestParam("start") LocalDateTime start, @RequestParam("end") LocalDateTime end) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getWeatherByDateRange(localizationId, start, end));
    }

    @PostMapping("/{localizationId}")
    public ResponseEntity<WeatherDto> createWeather(@Valid @RequestBody NewWeatherDto newWeatherDto
            , @PathVariable UUID localizationId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.createWeather(newWeatherDto,localizationId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WeatherDto> deleteWeather(@PathVariable UUID id) {
        weatherService.deleteWeather(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
