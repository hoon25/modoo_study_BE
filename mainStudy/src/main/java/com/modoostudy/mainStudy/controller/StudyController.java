package com.modoostudy.mainStudy.controller;


import com.modoostudy.mainStudy.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudyController {

    private final StudyService studyService;

    @GetMapping("/studyform")
    public




}
