package com.jojoldu.book.springboot.fifa.dto;

import com.jojoldu.book.springboot.fifa.domain.User;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserResponseDto {
    private String accessId;
    private String nickname;
    private int level;

    public User toEntity()
    {
        return User.builder()
                .accessId(accessId)
                .nickname(nickname)
                .level(level)
                .build();
    }
}