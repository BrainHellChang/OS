package com.gg.os.controller;

import com.gg.os.dto.ResponseDto;
import com.gg.os.dto.SignUpDto;
import com.gg.os.dto.SignInResponseDto;
import com.gg.os.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString());


        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<?> signIn(@RequestBody SignUpDto requestBody) {
        System.out.println(requestBody.toString());

        ResponseDto<?> result = authService.signIn(requestBody);
        return result;
    }
}
