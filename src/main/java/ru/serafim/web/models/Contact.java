package ru.serafim.web.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import ru.serafim.web.models.Address;

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
    @JoinColumn(name = "resting_plase_id")
    private RestingPlace restingPlace;


    @OneToMany(mappedBy = "contact")
    private List<Address> addressList;

    @OneToMany(mappedBy = "contact")
    private List<Phone> phoneList;
}
