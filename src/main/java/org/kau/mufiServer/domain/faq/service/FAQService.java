package org.kau.mufiServer.domain.faq.service;

import org.kau.mufiServer.domain.faq.FAQ;
import org.kau.mufiServer.domain.faq.dto.FAQContentDto;
import org.kau.mufiServer.domain.faq.dto.FAQDto;
import org.kau.mufiServer.domain.faq.repository.FAQRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FAQService {

    private final FAQRepository faqRepository;

    public FAQService(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<FAQDto> getFAQList() {
        return faqRepository.findAll().stream()
                .map(faq -> new FAQDto(faq.getId(), faq.getTitle()))
                .collect(Collectors.toList());
    }

    public FAQContentDto getFAQContent(Integer id) {
        FAQ faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException("FAQ not found"));
        return new FAQContentDto(faq.getTitle(), faq.getContent());
    }
}

