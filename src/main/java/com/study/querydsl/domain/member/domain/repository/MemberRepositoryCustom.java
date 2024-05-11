package com.study.querydsl.domain.member.domain.repository;


import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.dto.MemberTeamResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepositoryCustom {
    List<MemberTeamResponseDto> findMemberByMemberId(Long memberId);
}
