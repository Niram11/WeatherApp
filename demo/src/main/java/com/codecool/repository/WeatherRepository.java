package com.codecool.repository;

import com.codecool.repository.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, UUID> {

    @Query("select w from Weather w left join fetch Localization where Localization.id = :localizationId")
    List<Weather> getWeatherByLocalizationId(@Param("restaurantId") UUID restaurantId);

    @Query("select w from Weather w left join fetch Localization where Localization.name = :restaurantName")
    List<Weather> getWeatherByLocalizationName(@Param("restaurantName") String restaurantName);

    @Query("SELECT w FROM Weather w WHERE w.localization.id = :localizationId AND w.timestamp BETWEEN :start AND :end")
    List<Weather> getWeatherByLocalizationAndDateRange(@Param("localizationId") UUID localizationId,
                                                        @Param("start") LocalDateTime start,
                                                        @Param("end") LocalDateTime end);
}
