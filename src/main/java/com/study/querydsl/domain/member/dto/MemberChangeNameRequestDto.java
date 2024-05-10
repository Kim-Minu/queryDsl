package com.study.querydsl.domain.member.dto;

import com.study.querydsl.domain.member.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MemberChangeNameRequestDto(
    @NotNull
    Long id,
    @NotEmpty
    String name
) {


}