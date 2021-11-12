package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.repositories.RestPlacesRepository;

import java.util.List;

import static ru.serafim.web.dto.ChillPlaceDto.from;


@Service
@RequiredArgsConstructor
public class RestPlacesServiceImpl implements RestPlacesService {

    private final RestPlacesRepository restPlacesRepository;

    @Override
    public List<ChillPlaceDto> getAllRestPlases() {
        return from(restPlacesRepository.findAll());
    }

    @Override
    public ChillPlaceDto getRestPlaceByName(String name) {
        return from(restPlacesRepository.findByName(name));
    }


}
