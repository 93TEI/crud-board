package com.jojoldu.book.springboot.web;    //web 패키지 : 앞으로의 컨트롤러와 관련된 클래스들은 모두 여기에 담음

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//간단한 API를 만든다
@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다
public class HelloController {

    @GetMapping("/hello")// HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다
    public String hello(){
        return "hello";
    }

}
