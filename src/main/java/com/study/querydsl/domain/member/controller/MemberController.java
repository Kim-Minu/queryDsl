package com.study.querydsl.domain.member.controller;

import com.study.querydsl.domain.member.dto.MemberChangeNameRequestDto;
import com.study.querydsl.domain.member.dto.MemberCreateRequestDto;
import com.study.querydsl.domain.member.dto.MemberCreateResponseDto;
import com.study.querydsl.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<MemberCreateResponseDto> create(@RequestBody MemberCreateRequestDto requestDto) {
        return new ResponseEntity<>(memberService.create(requestDto), HttpStatus.CREATED);
    }

    @PatchMapping("/changeName")
    public ResponseEntity<?> changeName(@RequestBody MemberChangeNameRequestDto requestDto) {
      memberService.changeName(requestDto);
      return new ResponseEntity<>(HttpStatus.OK);
    }

}
