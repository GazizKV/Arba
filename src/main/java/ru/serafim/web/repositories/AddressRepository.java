package ru.serafim.web.repositories;

//  author:  ValitovGaziz
//  date:    13.12.2021
//  project: serafim

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
