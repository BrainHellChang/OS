package com.gg.os.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {
    // controller -> view 로 데이터를 응답해주는 DTO
    private String token;
    private int exprTime;
}
