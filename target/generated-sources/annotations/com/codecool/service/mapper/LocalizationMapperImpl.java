package com.codecool.service.mapper;

import com.codecool.dto.Localization.LocalizationDto;
import com.codecool.dto.Localization.NewLocalizationDto;
import com.codecool.repository.entity.Localization;
import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T15:06:43+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class LocalizationMapperImpl implements LocalizationMapper {

    @Override
    public Localization dtoToLocalization(NewLocalizationDto newLocalizationDto) {
        if ( newLocalizationDto == null ) {
            return null;
        }

        Localization localization = new Localization();

        localization.setName( newLocalizationDto.name() );
        localization.setLatitude( newLocalizationDto.latitude() );
        localization.setLongitude( newLocalizationDto.longitude() );

        return localization;
    }

    @Override
    public Localization dtoToLocalization(UUID id) {
        if ( id == null ) {
            return null;
        }

        Localization localization = new Localization();

        return localization;
    }

    @Override
    public LocalizationDto toDto(Localization createdLocation) {
        if ( createdLocation == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        BigDecimal latitude = null;
        BigDecimal longitude = null;

        id = createdLocation.getId();
        name = createdLocation.getName();
        latitude = createdLocation.getLatitude();
        longitude = createdLocation.getLongitude();

        LocalizationDto localizationDto = new LocalizationDto( id, name, latitude, longitude );

        return localizationDto;
    }
}
