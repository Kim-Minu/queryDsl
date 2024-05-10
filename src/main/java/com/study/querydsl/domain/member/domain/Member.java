package com.study.querydsl.domain.member.domain;

import com.study.querydsl.domain.team.domain.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.stream.Stream;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "member_name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public void changeMemberName(final String newName) {
        this.name = newName;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
