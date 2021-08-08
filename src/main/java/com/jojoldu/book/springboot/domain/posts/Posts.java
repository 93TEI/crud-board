package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동추가 (public Post(){} 과 같은 효과)
@Entity //  테이블과 링크될 클래스임을 나타냄. Entity클래스에는 절대 Setter 메소드를 만들지 않을것. 대신 해당 필드의ㅣ 값 변경이 필요함녀 명확히 그 목적을 나타낼 수 있는 메소드를 추가해야한다.
public class Posts extends BaseTimeEntity {
    // 실제 DB와 매칭될 클래스. // Entity클래스에서는 절대 Setter 메소드를 만들지말것. 만들어야하면 목적과 의도를 명확히나타낼수있는 메소드 추가할것.

    @Id // 기본키(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄. 괄호 안에 있는거 써야 auto_increment가 됨
    private Long id; // 웬만하면 Entity의 PK는 Long타입의 Auto_increment를 추천함. 주민번호와 같이 비즈니스상 유니크 키나 여러 키를 조합한 복합키를 PK를 잡을 경우 난감한 상황 발생 가능.

    @Column(length = 500, nullable = false) // 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됨. 사용 이유 : 사이즈를 500으로 늘리고싶거나 타입을 TEXT로 변경하고싶거나(content)
    private  String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
