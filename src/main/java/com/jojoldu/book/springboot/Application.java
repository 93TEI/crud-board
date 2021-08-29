package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableJpaAuditing  // JPA Auditing 활성화하는것. 근데 나중에 이걸 config에 JpaConfig을 생성하여 옮김
@SpringBootApplication
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행한다.
    }
}
