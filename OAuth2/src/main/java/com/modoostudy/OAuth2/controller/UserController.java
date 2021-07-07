package com.modoostudy.OAuth2.controller;


import com.modoostudy.OAuth2.dto.SignupDto;
import com.modoostudy.OAuth2.responseCode.success.DefaultRes;
import com.modoostudy.OAuth2.responseCode.success.ResponseMessage;
import com.modoostudy.OAuth2.responseCode.success.StatusCode;
import com.modoostudy.OAuth2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

//     회원가입 양식 컨트롤러
    @GetMapping("/signupform")
    public ResponseEntity signupForm() {
        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.SIGNUPFORM_LOAD_SUCCESS, userService.getSignupForm()), HttpStatus.OK);
    }

//     회원가입 버튼
    @PostMapping("/signupform/signup")
    public ResponseEntity signup(@RequestBody SignupDto signupVo) {

        userService.signup(signupVo);

        return new ResponseEntity(DefaultRes
                .res(StatusCode.OK, ResponseMessage.CREATED_USER),HttpStatus.OK);
    }


}
