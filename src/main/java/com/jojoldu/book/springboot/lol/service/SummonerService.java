package com.jojoldu.book.springboot.lol.service;


import com.jojoldu.book.springboot.lol.api.SummonerApiClient;
import com.jojoldu.book.springboot.lol.dto.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SummonerService
{
    @Autowired
    private final SummonerApiClient SummonerApiClient;

    @Transactional(readOnly = true)
    public SummonerDto searchSummoner(String summoner)
    {
        return SummonerApiClient.requestSummonerInfo(summoner);
    }
}