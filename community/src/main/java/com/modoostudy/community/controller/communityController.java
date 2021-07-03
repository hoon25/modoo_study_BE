package com.modoostudy.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/community")
public class communityController {
    public String community(){
        return "community.html";
    }

    @RequestMapping(value = "/topic")
    public String topic(){
        return "topic.html";
    }

    @RequestMapping(value = "/communityform")
    public String communityform(){
        return "communityform.html";
    }

}
