package com.study.querydsl.domain.member.domain.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.domain.member.domain.QMember;
import com.study.querydsl.domain.member.dto.MemberTeamResponseDto;
import com.study.querydsl.domain.team.domain.QTeam;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberTeamResponseDto> findMemberByMemberId(Long memberId) {

        QMember member = QMember.member;
        QTeam team = QTeam.team;

        JPAQuery<Tuple> result = jpaQueryFactory
                .select(
                    member.id,
                    member.name,
                    team.id,
                    team.name
                )
                .from(
                    member
                )
                .join(
                    team
                )
                .on(member.team.id.eq(team.id))
                .where(member.id.eq(memberId))
                .orderBy(member.id.asc());

        return result.fetchJoin().fetch()
                .stream()
                .map(
                    tuple ->
                        MemberTeamResponseDto.builder()
                                .memberId(tuple.get(member.id))
                                .memberName(tuple.get(member.email))
                                .teamId(tuple.get(team.id))
                                .teamName(tuple.get(team.name))
                        .build()

                ).toList();

    }
}
