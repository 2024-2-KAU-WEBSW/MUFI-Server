package org.kau.mufiServer.domain.member.repository;

import org.kau.mufiServer.domain.member.Member;
import org.kau.mufiServer.global.common.exception.model.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.kau.mufiServer.global.common.dto.enums.ErrorType.NOT_FOUND_MEMBER_ERROR;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByKakaoId(String kakaoId);

    Optional<Member> findByKakaoId(String kakaoId);

    default Member findByIdOrThrow(Long id) {
        return this.findById(id)
                .orElseThrow(() -> new CustomException(NOT_FOUND_MEMBER_ERROR));
    }
}
