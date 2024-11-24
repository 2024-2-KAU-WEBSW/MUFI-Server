package org.kau.mufiServer.domain.gallery.service;

import org.kau.mufiServer.domain.gallery.dto.GalleryDto;
import org.kau.mufiServer.domain.gallery.repository.GalleryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryService {
    private final GalleryRepository galleryRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<GalleryDto> getGalleryImages() {
        return galleryRepository.findAll().stream()
                .map(image -> new GalleryDto(image.getId(), image.getImage()))
                .collect(Collectors.toList());
    }
}
