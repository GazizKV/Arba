package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.ChillPlace;

import java.util.List;

public interface ChillPlaceRepository extends JpaRepository<ChillPlace, Long> {
    ChillPlace findAllByName(String name);

    void deleteById(Long id);
}
