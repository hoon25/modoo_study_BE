package com.modoostudy.mainStudy.controller;


import com.modoostudy.mainStudy.entity.User;
import com.modoostudy.mainStudy.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public List<User> getUser() {
        System.out.println(userService.getAllUser());
        System.out.println();

        return userService.getAllUser();
    }

    @GetMapping("/free")
    public String free() {
        String text = "자유롭게 들어올수 있습니다.";
        return text;
    }

    @GetMapping("/authorize")
    public String authorize() {
        String text = "권한이 필요합니다.";

        userService.getUserID();



        return text;
    }



}
