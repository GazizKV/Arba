package ru.serafim.web.dto;

import lombok.*;
import ru.serafim.web.models.ChillPlace;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChillPlaceDto {
    private String name;
    private Integer serviceRate;
    private ContactDto contactDto;
    private AccountDto accountDto;

    public static ChillPlaceDto from(ChillPlace place) {
        return ChillPlaceDto.builder()
                .name(place.getName())
                .accountDto(AccountDto.from(place.getAccount()))
                .serviceRate(place.getServiceRate())
                .contactDto(ContactDto.from(place.getContact_id()))
                .build();
    }

    public static List<ChillPlaceDto> from(List<ChillPlace> restingPlaces) {
        return restingPlaces.stream().map(ChillPlaceDto::from).collect(Collectors.toList());
    }
}
