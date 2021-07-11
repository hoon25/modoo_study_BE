package com.modoostudy.community.controller;

import com.modoostudy.community.domain.entity.communityTB;
import com.modoostudy.community.service.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/community")
public class communityController {

//    public String community(){
//        return "community.html";
//    }
    private CommunityService communityService;

    @GetMapping("")
    public communityTB community(@RequestParam(value = "communityID") Long communityID) {
        return communityService.findById(communityID);
    }
}
