package ru.serafim.web.services;

import ru.serafim.web.dto.ChillPlaceDto;

import java.util.List;

public interface ChillPlacesService {

    List<ChillPlaceDto> getAllRestPlases();

    ChillPlaceDto getChillPlaceByEmail(String email);

    ChillPlaceDto getChillPlaceById(Long id);

    ChillPlaceDto getChillPlaceByName(String name);
}
