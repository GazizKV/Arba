package ru.serafim.web.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChillPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer serviceRate;

    private String phone;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "chill_place", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<FilesMetaData> filesMetaDataList;

    @OneToMany(mappedBy = "chillPlace", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Badge> badges;

}
