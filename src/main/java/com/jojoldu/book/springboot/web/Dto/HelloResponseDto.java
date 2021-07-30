package com.jojoldu.book.springboot.web.Dto;
//dto : 데이터 트랜스퍼 오브잭스
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성해준다
@RequiredArgsConstructor // final로 선언된 모든 필드를 포함한 생성자를 생성해준다. final이 없는 필드는 생성자에 포함X
public class HelloResponseDto {

    private  final String name;
    private  final  int amount;

}
