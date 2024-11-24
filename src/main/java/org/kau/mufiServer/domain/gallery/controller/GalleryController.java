package org.kau.mufiServer.domain.gallery.controller;

import org.kau.mufiServer.domain.gallery.dto.GalleryDto;
import org.kau.mufiServer.domain.gallery.service.GalleryService;
import org.kau.mufiServer.global.common.dto.ApiResponse;
import org.kau.mufiServer.global.common.dto.enums.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {
    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/image")
    public ResponseEntity<?> getGalleryImages() {
        List<GalleryDto> images = galleryService.getGalleryImages();
        return ResponseEntity.ok(ApiResponse.success(SuccessType.PROCESS_SUCCESS, images));
    }
}
