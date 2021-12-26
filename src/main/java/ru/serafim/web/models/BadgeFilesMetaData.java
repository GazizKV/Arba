package ru.serafim.web.models;

//  author:  ValitovGaziz
//  date:    26.12.2021
//  project: serafim

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class BadgeFilesMetaData {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "storage_file_name")
    private String storageFileName;

    private Long size;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "original_file_name")
    private String originalFileName;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @Column(length = 1000)
    private String description;


}
