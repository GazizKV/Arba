package ru.serafim.web.services;

import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.models.FilesMetaData;

import java.util.List;
import java.util.Optional;

public interface ChillPlacesService {

    List<ChillPlaceDto> getAllRestPlases();

    ChillPlaceDto getChillPlaceByEmail(String email);

    ChillPlaceDto getChillPlaceById(Long id);

    ChillPlaceDto getChillPlaceByName(String name);

    String save(ChillPlaceDto chillPlaceDto);

    void deleteById(Long id);

    Optional<List<ChillPlaceDto>> getChillPlaceByAccountId(Long id);
}
