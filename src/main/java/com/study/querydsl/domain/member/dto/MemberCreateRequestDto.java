package com.study.querydsl.domain.member.dto;

import com.study.querydsl.domain.member.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MemberCreateRequestDto(
    @NotNull
    @Email
    String email,
    @NotEmpty
    String name
) {

  public Member toEntity() {

    return Member.builder()
        .email(email)
        .name(name)
        .build();
  }

}