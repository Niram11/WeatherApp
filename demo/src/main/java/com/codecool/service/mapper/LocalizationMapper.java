package com.codecool.service.mapper;

import com.codecool.dto.Localization.LocalizationDto;
import com.codecool.dto.Localization.NewLocalizationDto;
import com.codecool.repository.entity.Localization;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface LocalizationMapper {

    Localization dtoToLocalization(NewLocalizationDto newLocalizationDto);
    Localization dtoToLocalization(UUID id);
    LocalizationDto toDto(Localization createdLocation);
}
