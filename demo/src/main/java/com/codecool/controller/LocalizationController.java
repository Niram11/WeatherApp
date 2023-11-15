package com.codecool.controller;

import com.codecool.dto.Localization.LocalizationDto;
import com.codecool.dto.Localization.NewLocalizationDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/localization")
public class LocalizationController {

    @PostMapping
    public ResponseEntity<LocalizationDto> createLocalization(@Valid @RequestBody NewLocalizationDto newLocalizationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body();
    }
}
