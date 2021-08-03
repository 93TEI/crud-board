package com.jojoldu.book.springboot.domain.posts;

//다른곳에서 DAO라고 불리는 DB Layer접근자. JPA에서는 Repository라고 부름.
//@Repository를 추가할 필요없음. Entity클래스와 Repository는 함께 위치해야함

import org.springframework.data.jpa.repository.JpaRepository;

//Posts클래스로 Database를 접근하게 해줄 JpaRepository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JpaRepository<엔티티 클래스, PK타입>을 상속하기만 하면 기본적인 CRUD 메소드가 자동생성됨
}
