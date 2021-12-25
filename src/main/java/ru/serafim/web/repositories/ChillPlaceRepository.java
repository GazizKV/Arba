package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.ChillPlace;

import java.util.List;
import java.util.Optional;

public interface ChillPlaceRepository extends JpaRepository<ChillPlace, Long> {

    ChillPlace findAllByName(String name);

    void deleteById(Long id);

    Optional<List<ChillPlace>> findAllByAccount_Id(Long aLong);

}
