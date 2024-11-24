package org.kau.mufiServer.domain.gallery;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "gallery")
public class Gallery {

    @Id
    @Column(name = "gallery_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String image;
}
