package ru.serafim.web.dto;

import lombok.*;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.models.FilesMetaData;

import java.util.List;
import java.util.stream.Collectors;

import static ru.serafim.web.dto.AccountDto.from;
import static ru.serafim.web.dto.ContactDto.from;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChillPlaceDto {
    private Long id;
    private String name;
    private Integer serviceRate;
    private List<ContactDto> contactDtoList;
    private AccountDto accountDto;
    private String description;

    public static ChillPlaceDto from(ChillPlace place) {
        return ChillPlaceDto.builder()
                .id(place.getId())
                .name(place.getName())
                .serviceRate(place.getServiceRate())
                .description(place.getDescription())
                .build();
    }

    public static List<ChillPlaceDto> from(List<ChillPlace> restingPlaces) {
        return restingPlaces
                .stream()
                .map(ChillPlaceDto::from)
                .collect(Collectors.toList());
    }
}
