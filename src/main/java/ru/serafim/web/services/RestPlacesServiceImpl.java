package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.RestingPlaceDto;
import ru.serafim.web.repositories.RestPlacesRepository;

import java.util.List;

import static ru.serafim.web.dto.RestingPlaceDto.from;


@Service
@RequiredArgsConstructor
public class RestPlacesServiceImpl implements RestPlacesService {

    private final RestPlacesRepository restPlacesRepository;

    @Override
    public List<ru.serafim.web.dto.RestingPlaceDto> getAllRestPlases() {
        return from(restPlacesRepository.findAll());
    }

    @Override
    public RestingPlaceDto getRestPlaceByName(String name) {
        return from(restPlacesRepository.findByName(name));
    }


}
