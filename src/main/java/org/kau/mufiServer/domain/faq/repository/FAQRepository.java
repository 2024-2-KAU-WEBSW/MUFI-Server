package org.kau.mufiServer.domain.faq.repository;

import org.kau.mufiServer.domain.faq.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
}

