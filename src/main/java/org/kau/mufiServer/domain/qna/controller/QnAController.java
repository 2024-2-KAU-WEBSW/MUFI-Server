package org.kau.mufiServer.domain.qna.controller;

import org.kau.mufiServer.domain.qna.dto.QnAContentDto;
import org.kau.mufiServer.domain.qna.dto.QnADto;
import org.kau.mufiServer.domain.qna.dto.QnARequestDto;
import org.kau.mufiServer.domain.qna.service.QnAService;
import org.kau.mufiServer.global.common.dto.ApiResponse;
import org.kau.mufiServer.global.common.dto.enums.SuccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.kau.mufiServer.global.common.dto.enums.SuccessType.*;

@RestController
@RequestMapping("/api/qna")
public class QnAController {
    private final QnAService qnaService;

    public QnAController(QnAService qnaService) {
        this.qnaService = qnaService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getQnAList() {
        List<QnADto> qnaList = qnaService.getQnAList();
        return ResponseEntity.ok(ApiResponse.success(PROCESS_SUCCESS, qnaList));
    }

    @PostMapping("/content")
    public ResponseEntity<?> getQnAContent(@RequestBody Map<String, Integer> request) {
        QnAContentDto qnaContent = qnaService.getQnAContent(request.get("id"));
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(PROCESS_CREATED, qnaContent));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerQnA(@RequestBody QnARequestDto qnaRequest) {
        qnaService.registerQnA(qnaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(PROCESS_CREATED));
    }
}
