package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.dto.StudyDto;
import com.modoostudy.mainStudy.dto.function.mystudy.ReadMainMyStudy;
import com.modoostudy.mainStudy.dto.function.study.LoginUserDto;
import com.modoostudy.mainStudy.entity.MappingStudyGuest;
import com.modoostudy.mainStudy.entity.Study;
import com.modoostudy.mainStudy.entity.User;
import com.modoostudy.mainStudy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyStudyService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final RegionRepository regionRepository;
    private final StudyRepository studyRepository;
    private final MappingStudyInterestRepository mappingStudyInterestRepository;
    private final MappingStudyGuestRepository mappingStudyGuestRepository;
    private final MappingUserInterestRepository mappingUserInterestRepository;

    /**
     * JWT 토큰으로부터 로그인 유저 정보 가져오기
     */
    public LoginUserDto getUserFromJWT() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        User user = userRepository.findByGEmail(authentication.getName());

        return LoginUserDto.builder()
                .userID(user.getUserID())
                .GEmail(user.getGEmail())
                .nickName(user.getNickname())
                .build();
    }

    /**
     * Mystudy 메인페이지 서비스
     */

    public ReadMainMyStudy getMystudyPage() {
        LoginUserDto loginUserDto = getUserFromJWT();
        User user = userRepository.findByUserID(loginUserDto.getUserID());
        Map<String, List<Study>> myStudyList =
                user.getStudyGuests().stream()
                        .filter(name->name.getStatus().contentEquals("승인"))
                        .map(MappingStudyGuest::getStudy)
                        .collect(Collectors.groupingBy(Study::getStudyStatus));

        System.out.println(myStudyList.toString());

        List<StudyDto.MainMyStudy> progressStudy = new ArrayList<>();
        List<StudyDto.MainMyStudy> endStudy = new ArrayList<>();

        if(myStudyList.get("진행중") != null){
            for(Study study : myStudyList.get("진행중")){
                progressStudy.add(StudyDto.MainMyStudy.builder()
                        .title(study.getTitle())
                        .hostBoolean(study.getUser().getUserID().equals(loginUserDto.getUserID()))
                        .build());
            }
        }


        if(myStudyList.get("종료") != null){
            for(Study study : myStudyList.get("종료")){
                endStudy.add(StudyDto.MainMyStudy.builder()
                        .title(study.getTitle())
                        .hostBoolean(study.getUser().getUserID().equals(loginUserDto.getUserID()))
                        .build());
            }
        }


        return ReadMainMyStudy.builder()
                .loginUserDto(loginUserDto)
                .progressStudyList(progressStudy)
                .endStudyList(endStudy).build();
    }


}
