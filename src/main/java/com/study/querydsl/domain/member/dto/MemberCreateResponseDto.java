package com.study.querydsl.domain.member.dto;

import com.study.querydsl.domain.member.domain.Member;

public record MemberCreateResponseDto(
    Long id,
    String name,
    String email
) {

    public MemberCreateResponseDto(Member member) {
        this(member.getId(), member.getName(), member.getEmail());
    }

}
