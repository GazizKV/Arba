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
public class ChillPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer serviceRate;

    @OneToMany(mappedBy = "chill_place", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Contact> contact;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "chill_place", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<FilesMetaData> filesMetaDataList;

}
