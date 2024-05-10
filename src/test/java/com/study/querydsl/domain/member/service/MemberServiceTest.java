package com.study.querydsl.domain.member.service;


import com.study.querydsl.domain.member.domain.Member;
import com.study.querydsl.domain.member.domain.repository.MemberRepository;
import com.study.querydsl.domain.member.dto.MemberCreateRequestDto;
import jakarta.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 생성 () {

      Member member = createMember();

      Member newMember = memberRepository.save(member);

      assertThat(newMember).isEqualTo(member);

    }

    @Test
    @Transactional
    public void 이름변경 () {

      Member member = createMember();

      member = memberRepository.save(member);

      member.changeMemberName("홍길동");

      member = memberRepository.findById(member.getId()).get();

      assertThat(member.getName()).isEqualTo("홍길동");

    }


    public Member createMember() {

      return new MemberCreateRequestDto(
          "test@naver.com",
          "tester"
      ).toEntity();


    }

}
