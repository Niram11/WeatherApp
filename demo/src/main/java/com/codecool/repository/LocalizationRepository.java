package com.codecool.repository;

import com.codecool.repository.entity.Localization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocalizationRepository extends JpaRepository<Localization, UUID> {
}
