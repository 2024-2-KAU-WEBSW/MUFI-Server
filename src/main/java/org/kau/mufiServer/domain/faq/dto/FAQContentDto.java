package org.kau.mufiServer.domain.faq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FAQContentDto {
    private String title;
    private String content;
}
