package com.jojoldu.book.springboot.config.auth.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserResponseDto {
    private String accessId;
    private String nickname;
    private int level;
}