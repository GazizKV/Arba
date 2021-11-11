package ru.serafim.web.dto;

import lombok.*;
import ru.serafim.web.models.RestingPlace;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestingPlaceDto {
    private String name;
    private Integer serviceRate;
    private ContactDto contactDto;
    private AccountDto accountDto;

    public static RestingPlaceDto from(RestingPlace restingPlace) {
        return RestingPlaceDto.builder()
                .name(restingPlace.getName())
                .accountDto(AccountDto.from(restingPlace.getAccount()))
                .serviceRate(restingPlace.getServiceRate())
                .contactDto(ContactDto.from(restingPlace.getContact_id()))
                .build();
    }

    public static List<RestingPlaceDto> from(List<RestingPlace> restingPlaceList) {
        return restingPlaceList.stream().map(RestingPlaceDto::from).collect(Collectors.toList());
    }
}
