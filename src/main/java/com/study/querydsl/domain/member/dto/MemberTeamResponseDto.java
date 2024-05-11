package com.study.querydsl.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberTeamResponseDto {
        private Long memberId;
        private String memberName;
        private Long teamId;
        private String teamName;

        @Builder
        public MemberTeamResponseDto(Long memberId, String memberName, Long teamId, String teamName) {
                this.memberId = memberId;
                this.memberName = memberName;
                this.teamId = teamId;
                this.teamName = teamName;
        }
}
