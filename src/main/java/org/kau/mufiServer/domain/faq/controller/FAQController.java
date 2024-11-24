package org.kau.mufiServer.domain.faq.controller;

import org.kau.mufiServer.domain.faq.dto.FAQContentDto;
import org.kau.mufiServer.domain.faq.dto.FAQDto;
import org.kau.mufiServer.domain.faq.service.FAQService;
import org.kau.mufiServer.global.common.dto.ApiResponse;
import org.kau.mufiServer.global.common.dto.enums.SuccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.kau.mufiServer.global.common.dto.enums.SuccessType.*;

@RestController
@RequestMapping("/api/faq")
public class FAQController {
    private final FAQService faqService;

    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getFAQList() {
        List<FAQDto> faqList = faqService.getFAQList();
        return ResponseEntity.ok(ApiResponse.success(PROCESS_SUCCESS, faqList));
    }

    @PostMapping("/content")
    public ResponseEntity<?> getFAQContent(@RequestBody Map<String, Integer> request) {
        FAQContentDto faqContent = faqService.getFAQContent(request.get("id"));
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(PROCESS_CREATED, faqContent));
    }
}


