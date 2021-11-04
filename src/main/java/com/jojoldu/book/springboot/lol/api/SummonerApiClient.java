package com.jojoldu.book.springboot.lol.api;

import com.jojoldu.book.springboot.lol.config.ApiKey;
import com.jojoldu.book.springboot.lol.dto.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class SummonerApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    SummonerDto summonerDto;
    private final String SummonerInfoUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    public SummonerDto requestSummonerInfo(String summonerName)
    {
        summonerDto = restTemplate.getForObject(SummonerInfoUrl+summonerName+"?api_key="+ApiKey.API_KEY,SummonerDto.class);
        return summonerDto;
    }
}
