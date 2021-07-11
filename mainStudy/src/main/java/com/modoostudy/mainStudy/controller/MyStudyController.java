package com.modoostudy.mainStudy.controller;

import com.modoostudy.mainStudy.responseCode.success.DefaultRes;
import com.modoostudy.mainStudy.responseCode.success.ResponseMessage;
import com.modoostudy.mainStudy.responseCode.success.StatusCode;
import com.modoostudy.mainStudy.service.MyStudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyStudyController {

    private final MyStudyService myStudyService;

//     마이스터디 페이지
    @GetMapping("/mystudy")
    public ResponseEntity getMystudyPage(){

        myStudyService.getMystudyPage();

        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.READ_MYSTUDY), HttpStatus.OK);
    }





}
