package ru.serafim.web.models;

//  author:  ValitovGaziz
//  date:    25.12.2021
//  project: serafim

import lombok.*;

import javax.persistence.Entity;

public enum TypeOfRest {
    MONUMENT, PARK, FOUNTAIN, FAMOUS_BUILDING, THEATRE, MUSEUM, RELIGIOUS_STRUCTURES

    // TODO добавить все эти типы отдыха в класс Account
    //  вместе с репозиторием для иконок,
    //  сервисом для добавления и
    //  страницей для добавления?

}
