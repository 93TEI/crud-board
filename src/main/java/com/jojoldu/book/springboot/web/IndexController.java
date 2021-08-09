package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller //머스테치에 url을 매핑하기 위한 코드
public class IndexController {

    private final PostsService postsService;

    //Repository 를 통해 데이터베이스에 접근 해 데이터를 가져오고, Service 를 통해 Repository 의 메소드를 이용하게 했으니
    //이제 Controller 가 Service 메소드를 이용 할 시간이다.
    @GetMapping("/")
    public String index(Model model){ // Model은 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다/ postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
        model.addAttribute("posts",postsService.findAllDesc());
        return "index"; // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
                        // 그래서 결국엔 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게 된다.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
