package com.modoostudy.OAuth2.controller;


import com.modoostudy.OAuth2.dto.SignupDto;
import com.modoostudy.OAuth2.dto.SignupFormDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import com.modoostudy.OAuth2.model.User;
import com.modoostudy.OAuth2.repository.UserRepository;
import com.modoostudy.OAuth2.responseCode.DefaultRes;
import com.modoostudy.OAuth2.responseCode.ResponseMessage;
import com.modoostudy.OAuth2.responseCode.StatusCode;
import com.modoostudy.OAuth2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

//     회원가입 양식 컨트롤러
    @GetMapping("/signupform")
    public ResponseEntity signupForm() {
        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.SIGNUPFORM_LOAD_SUCCESS, userService.getSignupForm()), HttpStatus.OK);
    }

//     회원가입 버튼
    @PostMapping("/signupform/signup")
    public ResponseEntity signup(@RequestBody SignupDto signupVo) {

        userService.signup(signupVo);

        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.SIGNUP_SUCCESS),HttpStatus.OK);
    }

////    로그인
//    @PostMapping("/login")
//    public String login(@RequestBody Map<String, String> loginClient) {
//        return userService.login(loginClient);
//    }


//    @GetMapping("/createtest")
//    public void run() {
//
//        PasswordEncoder passwordEncoder;
//        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        User user = new User();
//        user.setUserID(1L);
//        user.setUserImage("hoonimage");
//        user.setAuthorities(1);
//        user.setGEmail("cchoon95@gmail.com");
//        user.setNickname("hoon");
//        user.setPassword(passwordEncoder.encode("hoon1234"));
//        user.setRegion("Seoul");
//
//        userRepository.save(user);
//        System.out.println("create User Complete");
//
//    }
//
//    @GetMapping("/free")
//    public String free(){
//        String free = "자유롭게 들어올 수 있습니다.";
//        return free;
//    }
//
//    @GetMapping("/authorize")
//    public String autho(){
//        String autho = "권한승인";
//        return autho;
//    }







}
