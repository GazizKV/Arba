package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestPlacesRepository extends JpaRepository<RestingPlaceDto, Long> {
    RestingPlaceDto findByName(String name);
}
