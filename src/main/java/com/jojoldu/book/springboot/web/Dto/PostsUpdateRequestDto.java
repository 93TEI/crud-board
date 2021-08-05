package com.jojoldu.book.springboot.web.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//update 기능에 쿼리 날리는 부분이 없는 이유는 JPA의 영속성 컨텍스트 때문

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private  String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
