package ru.serafim.web.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;

    private String district;

    private String locality;

    private String street;

    @Column(name = "structure_number")
    private Integer structureNumber;

    @Column(name = "office_number")
    private Integer officeNumber;

    @ManyToOne
    @JoinColumn(name = "contact")
    private Contact contact;

}
