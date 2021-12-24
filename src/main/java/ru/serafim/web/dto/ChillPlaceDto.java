package ru.serafim.web.dto;

import lombok.*;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.models.FilesMetaData;

import java.util.List;
import java.util.stream.Collectors;

import static ru.serafim.web.dto.AccountDto.from;

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
    private String address;
    private String phone;
    private Long accountId;
    private String description;

    public static ChillPlaceDto from(ChillPlace place) {
        return ChillPlaceDto.builder()
                .id(place.getId())
                .name(place.getName())
                .serviceRate(place.getServiceRate())
                .description(place.getDescription())
                .accountId(place.getAccount().getId())
                .address(place.getAddress())
                .phone(place.getPhone())
                .build();
    }

    public static List<ChillPlaceDto> from(List<ChillPlace> restingPlaces) {
        return restingPlaces
                .stream()
                .map(ChillPlaceDto::from)
                .collect(Collectors.toList());
    }
}
