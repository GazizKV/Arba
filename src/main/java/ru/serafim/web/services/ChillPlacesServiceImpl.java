package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.models.State;
import ru.serafim.web.repositories.AccountsRepository;
import ru.serafim.web.repositories.ChillPlaceRepository;

import java.util.List;
import java.util.Optional;

import static ru.serafim.web.dto.ChillPlaceDto.from;


@Service
@RequiredArgsConstructor
public class ChillPlacesServiceImpl implements ChillPlacesService {

    private final ChillPlaceRepository chillPlaceRepository;

    private final AccountsRepository accountsRepository;

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
                .address(chillPlaceDto.getAddress())
                .phone(chillPlaceDto.getPhone())
                .account(accountsRepository.getById(chillPlaceDto.getAccountId()))
                .build();
        ChillPlace save = chillPlaceRepository.save(chillPlace);
        if(save.equals(null)) {
            return "File not saved, try again";
        }
        return "Saved successfully";
    }

    @Override
    public String deleteById(Long id) {
        Optional<ChillPlace> optChillPlace = chillPlaceRepository.findById(id);
        if(optChillPlace.isPresent()) {
            ChillPlace chillPlace = optChillPlace.get();
            chillPlace.setState(State.DELETED);
            chillPlaceRepository.save(chillPlace);
            return "deleted";
        }
        return "Not deleted because chillPlace by this id was not found. Your can send save appeal to this " +
                "emal or call by phone written into footer of this site";
    }

    @Override
    public Optional<List<ChillPlaceDto>> getChillPlaceByAccountId(Long id) {
        Optional<List<ChillPlace>> allByAccount_id = chillPlaceRepository.findAllByAccount_Id(id);
        return Optional.ofNullable(from(allByAccount_id.get()));
    }
}
