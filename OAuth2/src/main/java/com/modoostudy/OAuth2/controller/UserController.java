package com.modoostudy.OAuth2.controller;


import com.modoostudy.OAuth2.domain.User;
import com.modoostudy.OAuth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/create")
    public void run() {

        PasswordEncoder passwordEncoder;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User user = new User();
        user.setUserID(1);
        user.setUserImage("hoonimage");
        user.setAuthorities(1);
        user.setGEmail("cchoon95@gmail.com");
        user.setNickname("hoon");
        user.setPassword(passwordEncoder.encode("hoon1234"));
        user.setRegion("Seoul");

        userRepository.save(user);


//        userRepository.save(User.builder()
//                .userID(1)
//                .authorities(0)
//                .GEmail("cchoon95@naver.com")
//                .nickname("hoon")
//                .userImage("cchoon95image")
//                .password(passwordEncoder.encode("hoon1234")).build());

        System.out.println("create User Complete");

    }







}
