package com.modoostudy.user.controller;

import com.modoostudy.user.dto.ImageDto;
import com.modoostudy.user.dto.UserDto;
import com.modoostudy.user.service.EmblemService;
import com.modoostudy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mypage")
public class UserController {

    private final UserService userService;
    private final EmblemService emblemService;

    @Autowired
    public UserController(UserService userService, EmblemService emblemService) {
        this.userService = userService;
        this.emblemService = emblemService;
    }

    @GetMapping("{id}/information")
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

//    @PostMapping("{id}/information")
//    public String modifyInformation(@PathVariable("id") Long id) {
//        return "redirect:{id}/information";
//    }

    @GetMapping("{id}/emblem")
    public List getMyEmblem(@PathVariable("id") Long id) {
        return emblemService.getEmblem(id);
    }

    @GetMapping("{id}/emblemAll")
    public List getAllEmblem(@PathVariable("id") Long id) {
        return emblemService.getAllEmblem(id);
    }

    @GetMapping("{id}/image")
    public ImageDto getImage(@PathVariable("id") Long id) {
        return userService.getUserImage(id);
    }

    @PostMapping("{id}/imageSet")
    public void updateImage(@PathVariable("id") Long id, @RequestBody String imageUrl) {
        userService.updateImage(id, imageUrl);
    }

//    @GetMapping("all")
//    public List<User> allUser() {
//        return userService.allUser();
//    }
}
