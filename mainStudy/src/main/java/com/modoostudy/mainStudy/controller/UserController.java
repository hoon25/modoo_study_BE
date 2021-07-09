package com.modoostudy.mainStudy.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {


    @GetMapping("/free")
    public String free() {
        String text = "자유롭게 들어올수 있습니다.";
        return text;
    }

    @GetMapping("/authorize")
    public String authorize() {
        String text = "권한이 필요합니다.";
        return text;
    }



}
