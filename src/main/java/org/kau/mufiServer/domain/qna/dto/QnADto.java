package org.kau.mufiServer.domain.qna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QnADto {
    private Integer id;
    private String title;
    private Boolean answerDone;
}