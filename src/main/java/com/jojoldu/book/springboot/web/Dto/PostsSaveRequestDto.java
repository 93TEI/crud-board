package com.jojoldu.book.springboot.web.Dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto { // 뷰 레이어. 뷰를 위한 클래스로 Posts 엔티티 클래스와 역할을 철저히 분리해야함. 뷰를 위한 클래스는 자주 변경되기 때문
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}