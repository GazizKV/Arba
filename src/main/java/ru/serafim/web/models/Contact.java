package ru.serafim.web.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;

    @OneToOne
    @JoinColumn(name = "chill_place_id")
    private ChillPlace ChillPlace;


    @OneToMany(mappedBy = "contact")
    private List<Address> addressList;

    @OneToMany(mappedBy = "contact")
    private List<Phone> phoneList;
}
