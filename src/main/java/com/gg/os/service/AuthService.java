package com.gg.os.service;

import com.gg.os.dto.ResponseDto;
import com.gg.os.dto.SignUpDto;
import com.gg.os.entity.UserEntity;
import com.gg.os.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired UserRepository userRepository;

    public ResponseDto<?> signUp(SignUpDto dto) {
        System.out.println("AuthService.signUp() ==============");
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();
        String userNickname = dto.getUserNickname();

        // email 중복 확인 - existById : JPA에서 지원해주는거
        // DB 접근하는 친구는 try - catch문 써주자
        try {
            System.out.println("아이디 중복 탐색 - start : " + userEmail);
            if(userRepository.existsByUserEmail(userEmail)) {
                System.out.println("1");
                return ResponseDto.setFailed("Existed Email");
            } else {
                System.out.println("2");
            }
            System.out.println("finish" + userEmail);
        } catch (Exception e) {
            System.out.println("err : " + userEmail);
            return ResponseDto.setFailed("DB Error");
        }

        // 비번 다르면 틀림 ㅅㄱ
        if(!userPassword.equals(userPasswordCheck)) {
            System.out.println("?");
            return ResponseDto.setFailed("password does not matched!");
        }

        // UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);
        // UserRepository 를 이용하여 DB에 Entity 저장
        try {
            System.out.println("아이디 저장");
            userRepository.save(userEntity);
        } catch (Exception e) {
            ResponseDto.setFailed("DB Error");
        }
        System.out.println("????????");
        return ResponseDto.setSuccess("SignUp Success", null);
    }

    public ResponseDto<?> signIn(SignUpDto dto) {
        System.out.println("AuthService.signUp() ==============");

        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {
            System.out.println("[ ID / Password ] 일치 여부 확인");
            List<UserEntity> signInTF = userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);

            System.out.println(signInTF);
        } catch (Exception e) {
            System.out.println("?");
            System.out.println(e);
            ResponseDto.setFailed("DB error");
        }

        return ResponseDto.setSuccess("SignIn Success", null);
    }
}
