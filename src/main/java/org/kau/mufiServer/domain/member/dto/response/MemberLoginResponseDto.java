package org.kau.mufiServer.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.kau.mufiServer.domain.member.Member;
import org.kau.mufiServer.global.auth.jwt.TokenDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLoginResponseDto {

    private Long memberId;
    private TokenDto tokenDto;

    private String socialNickname;
    private String socialProfileImage;

    public static MemberLoginResponseDto of(Member loginMember, TokenDto tokenDto) {

        return new MemberLoginResponseDto(
                loginMember.getId(), tokenDto,
                loginMember.getSocialNickname(), loginMember.getSocialImage()
        );
    }
}
