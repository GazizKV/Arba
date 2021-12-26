package ru.serafim.web.services;

import ru.serafim.web.dto.ChillPlaceDto;

import java.util.List;
import java.util.Optional;

public interface ChillPlacesService {

    List<ChillPlaceDto> getAllRestPlases();

    ChillPlaceDto getChillPlaceByEmail(String email);

    ChillPlaceDto getChillPlaceById(Long id);

    ChillPlaceDto getChillPlaceByName(String name);

    String save(ChillPlaceDto chillPlaceDto);

    String deleteById(Long id);

    Optional<List<ChillPlaceDto>> getChillPlaceByAccountId(Long id);
}
