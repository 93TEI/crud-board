package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 스프링부트test와 Junit 사이에 연결자 역할. Junit에 내장된 실행자 외 다른 실행자 실행시키는데 여기서는 SpringRunner라는 스프링 실행자를 사용
@WebMvcTest(controllers = HelloController.class, // 여러 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입받음
    private MockMvc mvc; // 웹 API를 테스트할 때 사용, 스프링MVC테스트의 시작점, 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능
                        // Mock : 실제 사용하는 모듈이 아닌, 실제 모듈을 흉내내는 테스트용 모듈 -> 테스트 효율성 증가
    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  //MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함. 체이닝이 지원되어 아래에 이어서 선언 가능
                .andExpect(status().isOk()) //mvc.perform의 결과를 검증한다. HTTP Header의 Status를 검증한다. / 우리가 흔히 알고있는 200,404,500 등의 상태 검증. 여기선 OK 즉, 200인지 검증
                .andExpect(content().string(hello)); // mvc.pergorm의 결과를 검증. 응답 본문의 내용을 검증. Controoler에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))    //값은 String만 허용돼서 이렇게 바꿔줘야함
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(equalTo(name))) //교재대로 안되어서 구글링해서 바꾸니까 됨
                .andExpect(jsonPath("$.amount").value(equalTo(amount)));
    }

}