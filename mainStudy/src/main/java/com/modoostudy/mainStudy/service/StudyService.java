package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.dto.StudyDto;
import com.modoostudy.mainStudy.dto.StudyGuestDto;
import com.modoostudy.mainStudy.dto.StudyInterestDto;
import com.modoostudy.mainStudy.dto.function.CreateStudyDto;
import com.modoostudy.mainStudy.dto.function.LoginUserDto;
import com.modoostudy.mainStudy.dto.function.StudyFormDto;
import com.modoostudy.mainStudy.entity.*;
import com.modoostudy.mainStudy.mapper.*;
import com.modoostudy.mainStudy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class StudyService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final RegionRepository regionRepository;
    private final StudyRepository studyRepository;
    private final MappingStudyInterestRepository mappingStudyInterestRepository;
    private final MappingStudyGuestRepository mappingStudyGuestRepository;

//    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("name");
//    private final EntityManager em = emf.createEntityManager();


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
     * 스터디생성 폼 가져오기
     */

    public StudyFormDto getStudyForm() {

        return StudyFormDto.builder()
                .loginUserDto(getUserFromJWT())
                .interestDto(InterestMapper.INSTANCE.toDto(interestRepository.findAll()))
                .regionDto(RegionMapper.INSTANCE.toDto(regionRepository.findAll()))
                .build();
    }

    /**
     * 스터디 생성하기
     */
    public void createStudy(CreateStudyDto createStudyDto) {

        System.out.println(createStudyDto);
        System.out.println(createStudyDto.getRegistStudyInterestList());

        /*
        studyTB 입력
        */
        Study createStudyEntity = StudyMapper.INSTANCE.toEntity(
                StudyDto.builder()
                        .hostID(getUserFromJWT().getUserID())
                        .title(createStudyDto.getRegistStudy().getTitle())
                        .periodStart(createStudyDto.getRegistStudy().getPeriodStart())
                        .periodEnd(createStudyDto.getRegistStudy().getPeriodEnd())
                        .goal(createStudyDto.getRegistStudy().getGoal())
                        .need(createStudyDto.getRegistStudy().getNeed())
                        .onoffline(createStudyDto.getRegistStudy().getOnoffline())
                        .details(createStudyDto.getRegistStudy().getDetails())
                        .build());

        studyRepository.save(createStudyEntity);


        /*
        mappingStudyInterestTB 입력
         */
        Long registStudyID = createStudyEntity.getStudyID();

        for (StudyInterestDto.registStudyInterest interest : createStudyDto.getRegistStudyInterestList())
        {
            mappingStudyInterestRepository.save(
                    StudyInterestMapper.INSTANCE.toEntity(
                            StudyInterestDto.builder()
                                    .studyID(registStudyID)
                                    .interestID(interest.getInterestID())
                                    .build()));

        }
    }

    /**
     * 메인페이지 스터디 리스트 받아오기
     */

    /**
     * 스터디페이지 상세보기
     */
    public void readStudyDetail(Long studyID){

        System.out.println(studyRepository.findByStudyID(studyID));
        System.out.println(studyRepository.findByStudyID(studyID).getStudyID());
        System.out.println(studyRepository.findByStudyID(studyID).getStudyInterests());
        for (MappingStudyInterest mappingStudyInterestList : studyRepository.findByStudyID(studyID).getStudyInterests()){
            System.out.println(mappingStudyInterestList.getInterest().getInterestName());
        }








    }

    /**
     * 스터디 신청하기
     */
    public void applyStudyMember(Long studyID){
        MappingStudyGuest mappingStudyGuest = StudyGuestMapper.INSTANCE.toEntity(
                StudyGuestDto.builder()
                .guestID(getUserFromJWT().getUserID())
                .studyID(studyID)
                .status("대기")
                .build());

        mappingStudyGuestRepository.save(mappingStudyGuest);
    }



    /**
     * study - MappingStudyInterest - interest create 테스트 코드
     */
    public void testCreateMappingTable() {
        // 사용자가 Study를 만들 때 Study1개와 StudyInterest 다수를 입력한다.

        // 가상의 스터디 정보
        Study createStudyEntity = new Study();
//        createStudyEntity.setStudyID(10L);  // studyID는 auto_increament
        createStudyEntity.setDetails("디테일2");
        createStudyEntity.setGoal("목표");
        createStudyEntity.setHostID(1000L);
        createStudyEntity.setNeed("원하는거");
        createStudyEntity.setOnoffline(2L);
        createStudyEntity.setPeriodStart(LocalDate.now());
        createStudyEntity.setPeriodEnd(LocalDate.now());
        createStudyEntity.setTitle("제목2");
        createStudyEntity.setHostID(1L);


        // 가상의 studyInterest 2개
        MappingStudyInterest mappingStudyInterest1 = new MappingStudyInterest();
        Interest interest = new Interest();
        interest.setInterestID(10L);
        mappingStudyInterest1.setInterest(interest);

        MappingStudyInterest mappingStudyInterest2 = new MappingStudyInterest();
        Interest interest2 = new Interest();
        interest2.setInterestID(12L);
        mappingStudyInterest2.setInterest(interest2);


        // studyID의 값은 auto_increament로 save시 생성되므로, mappingStudyInterest보다 먼저 넣어준다.
        // 나중에 넣을 경우 studyID는 NULL이 나옴
        studyRepository.save(createStudyEntity);

        // mappingStudyInterest에 Study 값을 주입한다.
        // (mappingStudyInterest와 Study간의 의존관계 주입을 위해서, 실제로 Study를 저장하지는 않음)
        // FK에서 의존 관계를 주입해야한다.(PK에서는 주입 불가능)
        mappingStudyInterest1.setStudy(createStudyEntity);
        mappingStudyInterest2.setStudy(createStudyEntity);

        // mappingStudyInterest1,2에 주입된 study의 객체값은 같음
        System.out.println(mappingStudyInterest1.getStudy());
        System.out.println(mappingStudyInterest2.getStudy());

        // study값의 객체가 같으므로 같은 StudyID를 의존관계로 가지며 저장된다.
        mappingStudyInterestRepository.save(mappingStudyInterest1);
        mappingStudyInterestRepository.save(mappingStudyInterest2);
    }





}
