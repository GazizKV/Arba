package ru.serafim.web.models;

// Created by IntelliJ IDEA.
// User: valit
// Date: 14.11.2021
// Time: 9:47
// Project name: serafim
// To change this template use File | Settings | File Templates.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FilesMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "storage_file_name")
    private String storageFileName;

    private Long size;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "original_file_name")
    private String originalFileName;

    @ManyToOne
    @JoinColumn(name = "chill_place_id")
    private ChillPlace chill_place;

    @Column(length = 1000)
    private String description;

}
