package com.jojoldu.book.springboot.lol.web;

import com.jojoldu.book.springboot.lol.dto.SummonerDto;
import com.jojoldu.book.springboot.lol.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SummonerController {
    private final SummonerService summonerService;

    @GetMapping("/api/v1/user/lol/{summoner}")
    public SummonerDto get(@PathVariable String summoner)
    {
        return summonerService.searchSummoner(summoner);
    }

}
