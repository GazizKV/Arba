package ru.serafim.web.services;

import ru.serafim.web.dto.ChillPlaceDto;

import java.util.List;

public interface RestPlacesService {

    List<ChillPlaceDto> getAllRestPlases();

    ChillPlaceDto getRestPlaceByName(String email);
}
