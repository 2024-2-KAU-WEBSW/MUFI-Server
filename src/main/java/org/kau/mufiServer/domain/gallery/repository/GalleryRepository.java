package org.kau.mufiServer.domain.gallery.repository;

import org.kau.mufiServer.domain.gallery.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
}
