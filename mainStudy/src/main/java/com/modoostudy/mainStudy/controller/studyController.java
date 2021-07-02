package com.modoostudy.mainStudy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studyController {

    @RequestMapping("/")
    public String getUser() {

        return "user Information";
    }


}
