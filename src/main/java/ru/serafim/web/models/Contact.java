package ru.serafim.web.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chill_place_id")
    private ChillPlace chill_place;


    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Address> addressList;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Phone> phoneList;
}
