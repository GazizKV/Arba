package ru.serafim.web.services;

import ru.serafim.web.dto.RestingPlaceDto;

import java.util.List;

public interface RestPlacesService {

    List<ru.serafim.web.dto.RestingPlaceDto> getAllRestPlases();

    RestingPlaceDto getRestPlaceByName(String email);
}
