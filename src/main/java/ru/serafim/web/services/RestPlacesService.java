package ru.serafim.web.services;

import ru.serafim.web.dto.RestingPlaceDto;
import ru.serafim.web.models.RestingPlace;

import java.util.List;

public interface RestPlacesService {

    List<RestingPlaceDto> getAllRestPlases();

}
