package com.jojoldu.book.springboot.domain.posts;

// 여기서 save, findAll 기능을 테스트할 것

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정 없이 이 어노테이션을 사용할 경우 H2 데이터베이스를 자동으로 실행해줌.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // Junit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정. 배포 전 전체테스트를 수행할 대 테스트간 데이터 침범을 막기위해 사용.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시물";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // postsRepository.save는 테이블 posts에 insert/update 쿼리를 실행한다. id값이 있다면 update, 없다면 insert
                .title(title)
                .content(content)
                .author("email@naver.com")
                .build());

        //when
        List<Posts> postslist = postsRepository.findAll(); // postsRepository.findAll은 테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postslist.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
