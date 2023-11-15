package com.codecool.controller;

import com.codecool.dto.Localization.LocalizationDto;
import com.codecool.dto.Localization.NewLocalizationDto;
import com.codecool.service.LocalizationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/localization")
public class LocalizationController {
    private final LocalizationService localizationService;

    public LocalizationController(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizationDto> getLocalizationById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(localizationService.getLocalizationById(id));
    }

    @GetMapping
    public ResponseEntity<List<LocalizationDto>> getAllLocalizations() {
        return ResponseEntity.status(HttpStatus.OK).body(localizationService.getAllLocalizations());
    }

    @PostMapping
    public ResponseEntity<LocalizationDto> createLocalization(@Valid @RequestBody NewLocalizationDto newLocalizationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(localizationService.createLocalization(newLocalizationDto));
    }
}
