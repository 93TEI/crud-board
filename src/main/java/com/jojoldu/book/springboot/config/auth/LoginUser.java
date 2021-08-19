package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 이 어노테이션이 생설될 수 있는 위치를 지정한다 RARAMETER로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할수있다.
@Retention(RetentionPolicy.RUNTIME) //@Retention 어노테이션으로 어느 시점까지 어노테이션의 메모리를 가져갈 지 설정하고, @Target 어노테이션으로 필드, 메소드, 클래스, 파라미터 등 선언할 수 있는 타입을 설정하면 대부분 커스텀 어노테이션은 쉽게 생성할 수 있습니다. 여기서 속성부분만 설정해주면요
public @interface LoginUser {
}
