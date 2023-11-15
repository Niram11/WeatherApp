package com.codecool.repository;

import com.codecool.repository.entity.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, UUID> {
}
