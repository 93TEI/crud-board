package com.jojoldu.book.springboot.lol;

import com.jojoldu.book.springboot.lol.config.ApiKey;
import com.jojoldu.book.springboot.lol.dto.SummonerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SummonerSearchTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private SummonerDto userDB;

    private final String SummonerInfoUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";

    @Test
    public void SummonerSearch()
    {
        String summonerName = "블리츠그랩꾸드빵";

        userDB = restTemplate.getForObject(SummonerInfoUrl+summonerName+"?api_key="+ApiKey.API_KEY,SummonerDto.class);

        System.out.println(userDB);
    }

}
