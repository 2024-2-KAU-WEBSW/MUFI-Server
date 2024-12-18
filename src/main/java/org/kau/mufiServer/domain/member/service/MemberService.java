package org.kau.mufiServer.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kau.mufiServer.domain.member.Member;
import org.kau.mufiServer.domain.member.dto.response.MemberLoginResponseDto;
import org.kau.mufiServer.domain.member.repository.MemberRepository;
import org.kau.mufiServer.global.auth.fegin.kakao.KakaoLoginService;
import org.kau.mufiServer.global.auth.jwt.JwtProvider;
import org.kau.mufiServer.global.auth.jwt.TokenDto;
import org.kau.mufiServer.global.auth.security.UserAuthentication;
import org.kau.mufiServer.global.common.exception.model.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.kau.mufiServer.global.common.dto.enums.ErrorType.INVALID_TOKEN_HEADER_ERROR;
import static org.kau.mufiServer.global.common.dto.enums.ErrorType.NOT_FOUND_MEMBER_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    private final KakaoLoginService kakaoLoginService;

    private static String parseTokenString(String tokenString) {
        String[] strings = tokenString.split(" ");
        if (strings.length != 2) {
            throw new CustomException(INVALID_TOKEN_HEADER_ERROR);
        }
        return strings[1];
    }

    @Transactional
    public MemberLoginResponseDto login(String socialAccessToken) {

        socialAccessToken = parseTokenString(socialAccessToken);

        String kakaoId = kakaoLoginService.getKakaoId(socialAccessToken);

        boolean isRegistered = isUserByKakaoId(kakaoId);
        if (!isRegistered) {
            Member member = Member.builder()
                .kakaoId(kakaoId).build();

            memberRepository.save(member);
        }

        Member loginMember = getUserBySocialAndSocialId(kakaoId);
        // 카카오 로그인은 정보 더 많이 받아올 수 있으므로 추가 설정
        kakaoLoginService.setKakaoInfo(loginMember, socialAccessToken);

        TokenDto tokenDto = jwtProvider.issueToken(
            new UserAuthentication(loginMember.getId(), null, null));

        return MemberLoginResponseDto.of(loginMember, tokenDto);
    }

    @Transactional
    public TokenDto reissueToken(String refreshToken) {

        refreshToken = parseTokenString(refreshToken);

        Long memberId = jwtProvider.validateRefreshToken(refreshToken);
        validateMemberId(memberId);  // memberId가 DB에 저장된 유효한 값인지 검사

        jwtProvider.deleteRefreshToken(memberId);
        return jwtProvider.issueToken(new UserAuthentication(memberId, null, null));
    }

    @Transactional
    public void logout(Long memberId) {
        jwtProvider.deleteRefreshToken(memberId);
    }

    private void validateMemberId(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new CustomException(NOT_FOUND_MEMBER_ERROR);
        }
    }

    private Member getUserBySocialAndSocialId(String kakaoId) {
        return memberRepository.findByKakaoId(kakaoId)
            .orElseThrow(() -> new CustomException(NOT_FOUND_MEMBER_ERROR));
    }

    private boolean isUserByKakaoId(String kakaoId) {
        return memberRepository.existsByKakaoId(kakaoId);
    }
}