package com.modoostudy.mainStudy.controller;


import com.modoostudy.mainStudy.dto.function.CreateStudyDto;
import com.modoostudy.mainStudy.responseCode.success.DefaultRes;
import com.modoostudy.mainStudy.responseCode.success.ResponseMessage;
import com.modoostudy.mainStudy.responseCode.success.StatusCode;
import com.modoostudy.mainStudy.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudyController {

    private final StudyService studyService;

    // 스터디 생성 버튼 클릭시 제공 양식
    @GetMapping("/studyform")
    public ResponseEntity studyForm() {
        return new ResponseEntity(DefaultRes
        .res(StatusCode.OK, ResponseMessage.STUDYFORM_LOAD_SUCCESS, studyService.getStudyForm()), HttpStatus.OK);
    }

    // 스터디 생성버튼
    @PostMapping("/studyform/create")
    public ResponseEntity createStudy(@RequestBody CreateStudyDto createStudyDto) {

        studyService.createStudy(createStudyDto);

        return new ResponseEntity(DefaultRes
        .res(StatusCode.OK, ResponseMessage.CREATED_STUDY), HttpStatus.OK);
    }







}
