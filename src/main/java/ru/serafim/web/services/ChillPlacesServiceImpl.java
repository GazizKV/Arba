package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.repositories.ChillPlaceRepository;

import java.util.List;

import static ru.serafim.web.dto.ChillPlaceDto.from;


@Service
@RequiredArgsConstructor
public class ChillPlacesServiceImpl implements ChillPlacesService {

    private final ChillPlaceRepository chillPlaceRepository;

    @Override
    public List<ChillPlaceDto> getAllRestPlases() {
        return from(chillPlaceRepository.findAll());
    }

    @Override
    public ChillPlaceDto getChillPlaceByEmail(String name) {
        return from(chillPlaceRepository.findAllByName(name));
    }

    @Override
    public ChillPlaceDto getChillPlaceById(Long id) {
        return from(chillPlaceRepository.findById(id).get());
    }


}
