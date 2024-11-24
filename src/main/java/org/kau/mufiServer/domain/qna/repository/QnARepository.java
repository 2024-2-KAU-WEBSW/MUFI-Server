package org.kau.mufiServer.domain.qna.repository;

import org.kau.mufiServer.domain.qna.QnA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnARepository extends JpaRepository<QnA, Integer> {
}

