package com.modoostudy.mainStudy.controller;


import com.modoostudy.mainStudy.dto.function.study.CreateStudyDto;
import com.modoostudy.mainStudy.dto.function.study.ReadStudyDetailDto;
import com.modoostudy.mainStudy.dto.function.study.ReadStudyListDto;
import com.modoostudy.mainStudy.dto.function.study.StudyFormDto;
import com.modoostudy.mainStudy.responseCode.success.DefaultRes;
import com.modoostudy.mainStudy.responseCode.success.ResponseMessage;
import com.modoostudy.mainStudy.responseCode.success.StatusCode;
import com.modoostudy.mainStudy.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StudyController {

    private final StudyService studyService;

    // 스터디 생성 버튼 클릭시 제공 양식
    @GetMapping("/studyform")
    public ResponseEntity studyForm() {

        StudyFormDto studyFormDto = studyService.getStudyForm();

        return new ResponseEntity(DefaultRes
        .res(StatusCode.OK, ResponseMessage.STUDYFORM_LOAD_SUCCESS, studyFormDto), HttpStatus.OK);
    }

    // 스터디 생성버튼
    @PostMapping("/studyform/create")
    public ResponseEntity createStudy(@RequestBody CreateStudyDto createStudyDto) {

        studyService.createStudy(createStudyDto);

        return new ResponseEntity(DefaultRes
        .res(StatusCode.OK, ResponseMessage.CREATED_STUDY), HttpStatus.OK);
    }

    // 스터디 리스트보기
    @GetMapping("")
    public ResponseEntity readStudyList(){

        ReadStudyListDto readStudyList = studyService.getStudyList();

        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.READ_STUDYLIST, readStudyList), HttpStatus.OK);
    }

    // 스터디 상세보기
    @GetMapping("/study/{studyID}")
    public ResponseEntity readStudyDetail(@PathVariable("studyID") Long studyID){

        ReadStudyDetailDto readStudyDetail = studyService.readStudyDetail(studyID);

        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.READ_STUDYDETAIL,readStudyDetail), HttpStatus.OK);
    }


    // 스터디 신청하기
    @GetMapping("/study/{studyID}/apply")
    public ResponseEntity applyStudyMember(@PathVariable("studyID") Long studyID){

        studyService.applyStudyMember(studyID);


        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.APPLY_STUDY), HttpStatus.OK);
    }








}
