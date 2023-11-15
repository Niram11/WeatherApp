package com.codecool.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Location Id cannot be empty")
    private UUID locationId;

    @NotBlank(message = "Timestamp cannot be empty")
    private LocalDateTime timestamp;

    @NotBlank(message = "Temperature cannot be empty")
    private Double temperature;

    private Double sensedTemperature;

    @Min(value = 0, message = "Humidity must be greater then or equal 0")
    @Max(value = 100, message = "Humidity must be less then or equal 100")
    @NotBlank(message = "Humidity cannot be empty")
    private Integer humidity;

    @NotBlank(message = "Atmospheric pressure cannot be empty")
    private Integer atmosphericPressure;

    @Min(value = 0, message = "Wind speed must be greater then or equal 0")
    private Double windSpeed;

    @Min(value = 0, message = "Wind direction must be greater then or equal 0")
    @Max(value = 360, message = "Wind direction must be less then or equal 360")
    private Integer windDirection;

    private Double devPoint;

    public UUID getId() {
        return id;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getSensedTemperature() {
        return sensedTemperature;
    }

    public void setSensedTemperature(Double sensedTemperature) {
        this.sensedTemperature = sensedTemperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(Integer atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public Double getDevPoint() {
        return devPoint;
    }

    public void setDevPoint(Double devPoint) {
        this.devPoint = devPoint;
    }
}
