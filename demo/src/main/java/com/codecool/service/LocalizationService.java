package com.codecool.service;

import com.codecool.dto.Localization.LocalizationDto;
import com.codecool.dto.Localization.NewLocalizationDto;
import com.codecool.repository.LocalizationRepository;
import com.codecool.repository.entity.Localization;
import com.codecool.service.mapper.LocalizationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocalizationService {
    private final LocalizationRepository localizationRepository;
    private final LocalizationMapper mapper;

    public LocalizationService(LocalizationRepository localizationRepository, LocalizationMapper mapper) {
        this.localizationRepository = localizationRepository;
        this.mapper = mapper;
    }

    public LocalizationDto getLocalizationById(UUID id) {
        return localizationRepository.findById(id)
                .map(mapper::toDto)
                .get();
    }

    public List<LocalizationDto> getAllLocalizations() {
        return localizationRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public LocalizationDto createLocalization(NewLocalizationDto newLocalizationDto) {
        Localization createdLocation = localizationRepository.save(mapper.dtoToLocalization(newLocalizationDto));
        return mapper.toDto(createdLocation);
    }
}
