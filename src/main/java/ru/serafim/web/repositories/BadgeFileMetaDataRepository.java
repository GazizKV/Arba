package ru.serafim.web.repositories;

//  author:  ValitovGaziz
//  date:    26.12.2021
//  project: serafim

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.Badge;
import ru.serafim.web.models.BadgeFilesMetaData;

public interface BadgeFileMetaDataRepository extends JpaRepository<BadgeFilesMetaData, Long> {
}
