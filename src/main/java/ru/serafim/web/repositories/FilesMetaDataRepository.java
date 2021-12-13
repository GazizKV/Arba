package ru.serafim.web.repositories;

// Created by IntelliJ IDEA.
// User: valit
// Date: 14.11.2021
// Time: 9:56
// Project name: serafim
// To change this template use File | Settings | File Templates.


import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.FilesMetaData;

public interface FilesMetaDataRepository extends JpaRepository<FilesMetaData, Long> {
}
