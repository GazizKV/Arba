package ru.serafim.web.models;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "contct_id")
    private Contact contact_id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
