package com.jojoldu.book.springboot.fifa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column
    private String nickname;

    @Column
    private String accessId;

    @Column
    private int level;

    @Builder
    public User(String accessId, String nickname, int level)
    {
        this.accessId = accessId;
        this.nickname = nickname;
        this.level = level;
    }
}
