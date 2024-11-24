package org.kau.mufiServer.domain.qna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QnAContentDto {
    private String title;
    private String content;
    private String answer;
}
