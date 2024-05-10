package com.study.querydsl.domain.member.service;

import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.domain.repository.MemberRepository;
import com.study.querydsl.domain.member.dto.MemberChangeNameRequestDto;
import com.study.querydsl.domain.member.dto.MemberCreateRequestDto;
import com.study.querydsl.domain.member.dto.MemberCreateResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  @Transactional
  public MemberCreateResponseDto create(MemberCreateRequestDto requestDto) {

      Member member = memberRepository.save(requestDto.toEntity());

      return new MemberCreateResponseDto(member);
  }

  @Transactional
  public void changeName(MemberChangeNameRequestDto requestDto) {

    Long id = requestDto.id();
    String name = requestDto.name();

    Member member = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);

    member.changeMemberName(name);

  }



}
