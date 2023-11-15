package com.codecool.service.mapper;

import com.codecool.dto.Localization.LocalizationDto;
import com.codecool.dto.Localization.NewLocalizationDto;
import com.codecool.repository.entity.Localization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalizationMapper {

    Localization dtoToLocalization(NewLocalizationDto newLocalizationDto);


    LocalizationDto toDto(Localization createdLocation);
}
