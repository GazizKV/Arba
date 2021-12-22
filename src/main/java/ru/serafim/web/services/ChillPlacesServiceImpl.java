package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.repositories.ChillPlaceRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<ChillPlace> chillPlace = chillPlaceRepository.findById(id);
        if(chillPlace.isPresent()) {
            return from(chillPlace.get());
        } else {
            throw new NullPointerException("Can not find ChillPlace by this id.");
        }
    }

    @Override
    public ChillPlaceDto getChillPlaceByName(String name) {
        return from(chillPlaceRepository.findAllByName(name));
    }

    @Override
    public String save(ChillPlaceDto chillPlaceDto) {
        ChillPlace chillPlace = ChillPlace.builder()
                .name(chillPlaceDto.getName())
                .serviceRate(chillPlaceDto.getServiceRate())
                .description(chillPlaceDto.getDescription())
                .build();
        ChillPlace save = chillPlaceRepository.save(chillPlace);
        if(save.equals(null)) {
            return "File not saved, try again";
        }
        return "Loaded successfully";
    }

    @Override
    public void deleteById(Long id) {
        chillPlaceRepository.deleteById(id);
    }
}
