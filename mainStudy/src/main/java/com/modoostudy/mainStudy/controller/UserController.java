package com.modoostudy.mainStudy.controller;


import com.modoostudy.mainStudy.domain.User;
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

        return userService.getAllUser();
    }


}
