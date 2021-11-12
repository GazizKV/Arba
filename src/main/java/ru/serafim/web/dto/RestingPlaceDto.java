package ru.serafim.web.dto;

import lombok.*;

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

    public static RestingPlaceDto from(ru.serafim.web.models.RestingPlaceDto restingPlaceDto) {
        return ru.serafim.web.dto.RestingPlaceDto.builder()
                .name(restingPlaceDto.getName())
                .accountDto(AccountDto.from(restingPlaceDto.getAccount()))
                .serviceRate(restingPlaceDto.getServiceRate())
                .contactDto(ContactDto.from(restingPlaceDto.getContact_id()))
                .build();
    }

    public static List<RestingPlaceDto> from(List<ru.serafim.web.models.RestingPlaceDto> restingPlaceDtoList) {
        return restingPlaceDtoList.stream().map(ru.serafim.web.dto.RestingPlaceDto::from).collect(Collectors.toList());
    }
}
