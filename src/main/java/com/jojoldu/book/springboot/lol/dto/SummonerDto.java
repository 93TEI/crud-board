package com.jojoldu.book.springboot.lol.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class SummonerDto {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
}
