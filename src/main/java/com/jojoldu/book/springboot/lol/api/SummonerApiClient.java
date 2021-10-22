package com.jojoldu.book.springboot.lol.api;

import com.jojoldu.book.springboot.lol.config.ApiKey;
import com.jojoldu.book.springboot.lol.dto.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class SummonerApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String LOL_API_KEY = ApiKey.API_KEY;
    private final String SummonerInfoUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}";
    public SummonerDto requestSummonerInfo(String summonerName)
    {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", LOL_API_KEY);
        final HttpEntity entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(SummonerInfoUrl, HttpMethod.GET, entity, SummonerDto.class,summonerName).getBody();
    }
}
