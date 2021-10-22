package com.jojoldu.book.springboot.fifa.web;

import com.jojoldu.book.springboot.fifa.dto.UserResponseDto;
import com.jojoldu.book.springboot.fifa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/v1/user/fifa/{nickname}")
    public UserResponseDto get(@PathVariable String nickname) {
        return userService.searchUserInfo(nickname);
    }
}