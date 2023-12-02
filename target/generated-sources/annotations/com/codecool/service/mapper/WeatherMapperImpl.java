package com.codecool.service.mapper;

import com.codecool.dto.Weather.NewWeatherDto;
import com.codecool.dto.Weather.WeatherDto;
import com.codecool.repository.entity.Localization;
import com.codecool.repository.entity.Weather;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T15:06:43+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class WeatherMapperImpl implements WeatherMapper {

    @Override
    public Weather dtoToWeather(NewWeatherDto newWeatherDto) {
        if ( newWeatherDto == null ) {
            return null;
        }

        Weather weather = new Weather();

        weather.setTimestamp( newWeatherDto.timestamp() );
        weather.setTemperature( newWeatherDto.temperature() );
        weather.setSensedTemperature( newWeatherDto.sensedTemperature() );
        weather.setHumidity( newWeatherDto.humidity() );
        weather.setAtmosphericPressure( newWeatherDto.atmosphericPressure() );
        weather.setWindSpeed( newWeatherDto.windSpeed() );
        weather.setWindDirection( newWeatherDto.windDirection() );
        weather.setDevPoint( newWeatherDto.devPoint() );

        return weather;
    }

    @Override
    public Weather dtoToWeather(UUID id) {
        if ( id == null ) {
            return null;
        }

        Weather weather = new Weather();

        return weather;
    }

    @Override
    public WeatherDto toDto(Weather weather) {
        if ( weather == null ) {
            return null;
        }

        UUID id = null;
        Localization localization = null;
        LocalDateTime timestamp = null;
        Double temperature = null;
        Double sensedTemperature = null;
        Integer humidity = null;
        Integer atmosphericPressure = null;
        Double windSpeed = null;
        Integer windDirection = null;
        Double devPoint = null;

        id = weather.getId();
        localization = weather.getLocalization();
        timestamp = weather.getTimestamp();
        temperature = weather.getTemperature();
        sensedTemperature = weather.getSensedTemperature();
        humidity = weather.getHumidity();
        atmosphericPressure = weather.getAtmosphericPressure();
        windSpeed = weather.getWindSpeed();
        windDirection = weather.getWindDirection();
        devPoint = weather.getDevPoint();

        WeatherDto weatherDto = new WeatherDto( id, localization, timestamp, temperature, sensedTemperature, humidity, atmosphericPressure, windSpeed, windDirection, devPoint );

        return weatherDto;
    }
}
