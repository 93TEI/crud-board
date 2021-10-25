package com.jojoldu.book.springboot.fifa.web;

import com.jojoldu.book.springboot.fifa.dto.UserResponseDto;
import com.jojoldu.book.springboot.fifa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class FifaIndexController {
    private final UserService userService;

    @GetMapping("user/info/{nickname}")
    public String userInfo(@PathVariable String nickname, Model model)
    {
        UserResponseDto userResponseDto = userService.findById(nickname);
        model.addAttribute("user",userResponseDto);
        return "user-info";
    }
}
