package com.jojoldu.book.springboot.domain.posts;

//DAO라고 불리는 DB Layer접근자. JPA에서는 Repository라고 부름.
//@Repository를 추가할 필요없음. Entity클래스와 Repository는 함께 위치해야함

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
