package com.codecool.repository;

import com.codecool.repository.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherRepository extends JpaRepository<Weather, UUID> {
}
