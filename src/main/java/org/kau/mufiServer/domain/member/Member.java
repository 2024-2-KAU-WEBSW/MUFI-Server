package org.kau.mufiServer.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    /**
     * 소셜 로그인 관련
     */
    @Column(nullable = false)
    private String kakaoId;

    private String socialNickname;

    private String socialImage;

    // 로그인 새롭게 할 때마다 해당 필드들 업데이트
    public void updateSocialInfo(String socialNickname, String socialImage) {
        this.socialNickname = socialNickname;
        this.socialImage = socialImage;
    }

    @Builder
    public Member(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    public static Member of(String kakaoId) {
        return new Member(kakaoId);
    }
}
