package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.Dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor // 선언된 모든 final 필드가 포함 된 생성자 생성
@Controller //머스테치에 url을 매핑하기 위한 코드  / 이게 컨트롤러다 라는 뜻
public class IndexController {

    private final PostsService postsService;

    //Repository 를 통해 데이터베이스에 접근 해 데이터를 가져오고, Service 를 통해 Repository 의 메소드를 이용하게 했으니
    //이제 Controller 가 Service 메소드를 이용 할 시간이다.
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ // Model은 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다/ postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
        model.addAttribute("posts",postsService.findAllDesc());

        // index.mustache에서 userName을 사용할수 있게 userName을 model에 저장하는 코드 추가
        // 삭제한 코드 : SessionUser user = (SessionUser) httpSession.getAttribute("user"); // CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성. 즉, 로그인 성공시 "user"값 가져올수있다
        if(user!=null){
            model.addAttribute("userName",user.getName()); // 세션에 저장된 값이 있을때만 model에 userName으로 등록, 세션에 저장된 값이 없으면 model에 아무런 값이 없으니 로그인 버튼이 보임
        }
        return "index"; // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
                        // 그래서 결국엔 src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리하게 된다.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}") //글제목을 눌렀을 때 get요청을 받아서 보내주는 역할의 클래스
    public String postsUpdate(@PathVariable Long id, Model model){ // @PathVariable : URL 경로에 변수를 넣어줌
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto); // 뷰에 전달할 데이터를 키,값 으로 전달함

        return "posts-update";
    }
}
