package ru.serafim.web.models;

//  author:  ValitovGaziz
//  date:    25.12.2021
//  project: serafim

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private TypeOfRest name;

    @ManyToOne
    @JoinColumn(name = "chillPlace_id")
    private ChillPlace chillPlace;

    // TODO Нужно еще одно храшилище фото для иконок.
}
