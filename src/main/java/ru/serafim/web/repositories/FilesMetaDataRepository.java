package ru.serafim.web.repositories;

// Created by IntelliJ IDEA.
// User: valit
// Date: 14.11.2021
// Time: 9:56
// Project name: serafim
// To change this template use File | Settings | File Templates.


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.serafim.web.models.FilesMetaData;

import java.util.List;

public interface FilesMetaDataRepository extends JpaRepository<FilesMetaData, Long> {

    @Query("select b from FilesMetaData b where b.chill_place.id = :id")
    List<FilesMetaData> findAllByChillPlaceId(Long id);
}