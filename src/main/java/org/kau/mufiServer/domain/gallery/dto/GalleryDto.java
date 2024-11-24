package org.kau.mufiServer.domain.gallery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GalleryDto {
    private Integer id;
    private String image;
}