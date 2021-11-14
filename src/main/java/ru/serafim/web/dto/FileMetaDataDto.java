package ru.serafim.web.dto;

// Created by IntelliJ IDEA.
// User: valit
// Date: 14.11.2021
// Time: 12:40
// Project name: serafim
// To change this template use File | Settings | File Templates.

import lombok.*;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.models.FilesMetaData;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileMetaDataDto {
    private Long id;
    private String originalFileName;
    private String storageFileName;
    private Long size;
    private String contentType;
    private ChillPlaceDto chillPlaceDto;

    public static FileMetaDataDto from(FilesMetaData filesMetaData) {
        ChillPlace chillPlace = filesMetaData.getChill_place();
        ChillPlaceDto chillPlaceDto = ru.serafim.web.dto.ChillPlaceDto.from(chillPlace);
        return FileMetaDataDto.builder()
                .id(filesMetaData.getId())
                .storageFileName(filesMetaData.getStorageFileName())
                .size(filesMetaData.getSize())
                .contentType(filesMetaData.getContentType())
                .originalFileName(filesMetaData.getOriginalFileName())
                .chillPlaceDto(chillPlaceDto)
                .build();
    }

    public static List<FileMetaDataDto> from(List<FilesMetaData> filesMetaDataList) {
        return filesMetaDataList.stream().map(FileMetaDataDto::from).collect(Collectors.toList());
    }
}
