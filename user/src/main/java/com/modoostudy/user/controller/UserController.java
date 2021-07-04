package com.modoostudy.user.controller;

import com.modoostudy.user.domain.userTB;
import com.modoostudy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mypage")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}/information")
    public Optional<userTB> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("all")
    public List<userTB> allUser() {
        return userService.allUser();
    }
}
