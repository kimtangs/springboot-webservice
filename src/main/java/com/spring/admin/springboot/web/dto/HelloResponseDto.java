package com.spring.admin.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get 메솓르르 생성해 줍니다.
@RequiredArgsConstructor // 생성자 생성.
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
