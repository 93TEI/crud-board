package com.jojoldu.book.springboot.service;

import com.jojoldu.book.springboot.config.auth.dto.UserResponseDto;
import com.jojoldu.book.springboot.fifaApi.UserApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserApiClient userApiClient;

    @Transactional(readOnly = true)
    public UserResponseDto searchUserInfo(String nickname) {
        return userApiClient.requestUserInfo(nickname);
    }
}