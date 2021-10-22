package com.jojoldu.book.springboot.fifa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserSearchTest {

    @Autowired
    private TestRestTemplate restTemplate;

    UserResponseDto userDB;

    private final String API_KEY = ApiKey.API_KEY;
    private final String UserInfoUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname={nickname}";

    @Test
    public void nickNameSearch()
    {
        String nickname = "크로스할게요";
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");

        final HttpHeaders httpHeaders = new HttpHeaders();  //HttpHeaders는 서버에 데이터를 보내주는 방법
        httpHeaders.set("Authorization", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        userDB = restTemplate.exchange(UserInfoUrl, HttpMethod.GET, entity, UserResponseDto.class, nickname).getBody();
        System.out.println(userDB);
    }
}
