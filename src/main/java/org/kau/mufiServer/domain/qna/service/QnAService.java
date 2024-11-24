package org.kau.mufiServer.domain.qna.service;

import org.kau.mufiServer.domain.qna.QnA;
import org.kau.mufiServer.domain.qna.dto.QnAContentDto;
import org.kau.mufiServer.domain.qna.dto.QnADto;
import org.kau.mufiServer.domain.qna.dto.QnARequestDto;
import org.kau.mufiServer.domain.qna.repository.QnARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QnAService {

    private final QnARepository qnaRepository;

    public QnAService(QnARepository qnaRepository) {
        this.qnaRepository = qnaRepository;
    }

    public List<QnADto> getQnAList() {
        return qnaRepository.findAll().stream()
                .map(qna -> new QnADto(qna.getId(), qna.getTitle(), qna.getAnswer() != null))
                .collect(Collectors.toList());
    }

    public QnAContentDto getQnAContent(Integer id) {
        QnA qna = qnaRepository.findById(id).orElseThrow(() -> new RuntimeException("QnA not found"));
        return new QnAContentDto(qna.getTitle(), qna.getContent(), qna.getAnswer());
    }

    public void registerQnA(QnARequestDto qnaRequestDto) {
        QnA qna = new QnA();
        qna.setTitle(qnaRequestDto.getTitle());
        qna.setContent(qnaRequestDto.getContent());
        qnaRepository.save(qna);
    }
}

