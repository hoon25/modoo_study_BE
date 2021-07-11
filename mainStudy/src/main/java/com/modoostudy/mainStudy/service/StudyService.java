package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.dto.StudyDto;
import com.modoostudy.mainStudy.dto.StudyGuestDto;
import com.modoostudy.mainStudy.dto.StudyInterestDto;
import com.modoostudy.mainStudy.dto.function.*;
import com.modoostudy.mainStudy.entity.*;
import com.modoostudy.mainStudy.mapper.InterestMapper;
import com.modoostudy.mainStudy.mapper.RegionMapper;
import com.modoostudy.mainStudy.mapper.StudyGuestMapper;
import com.modoostudy.mainStudy.mapper.StudyMapper;
import com.modoostudy.mainStudy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudyService {

    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final RegionRepository regionRepository;
    private final StudyRepository studyRepository;
    private final MappingStudyInterestRepository mappingStudyInterestRepository;
    private final MappingStudyGuestRepository mappingStudyGuestRepository;
    private final MappingUserInterestRepository mappingUserInterestRepository;


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
                        .user(userRepository.findByUserID(getUserFromJWT().getUserID()))
                        .title(createStudyDto.getRegistStudy().getTitle())
                        .periodStart(createStudyDto.getRegistStudy().getPeriodStart())
                        .periodEnd(createStudyDto.getRegistStudy().getPeriodEnd())
                        .goal(createStudyDto.getRegistStudy().getGoal())
                        .need(createStudyDto.getRegistStudy().getNeed())
                        .onoffline(createStudyDto.getRegistStudy().getOnoffline())
                        .needPeople(createStudyDto.getRegistStudy().getNeedPeople())
                        .details(createStudyDto.getRegistStudy().getDetails())
                        .build());

        studyRepository.save(createStudyEntity);


        /*
        mappingStudyInterestTB 입력
         */
        Long registStudyID = createStudyEntity.getStudyID();
        List<StudyInterestDto.registStudyInterest> studyInterests = createStudyDto.getRegistStudyInterestList();
        System.out.println(studyInterests.get(0).getInterestID());
        System.out.println(studyInterests.get(1).getInterestID());


        for (StudyInterestDto.registStudyInterest studyInterest : studyInterests) {
            Interest interest = new Interest();
            interest.setInterestID(studyInterest.getInterestID());

            mappingStudyInterestRepository.save(
                    MappingStudyInterest.builder()
                            .study(createStudyEntity)
                            .interest(interest)
                            .build());
        }

        /*
        mappingStudyGuestTB에 hostID를 승인으로 입력
         */
        MappingStudyGuest mappingStudyGuest = StudyGuestMapper.INSTANCE.toEntity(
                StudyGuestDto.builder()
                        .user(userRepository.findByUserID(getUserFromJWT().getUserID()))
                        .study(createStudyEntity)
                        .status("승인")
                        .build());
        mappingStudyGuestRepository.save(mappingStudyGuest);
    }

    /**
     * 메인페이지 스터디 리스트 받아오기
     */
    public ReadStudyListDto getStudyList() {

        /*
        비로그인 시
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal().toString().contentEquals("anonymousUser"))
        {
            System.out.println("비회원입니다.");


            return ReadStudyListDto.builder()
//                .readStudyList()
                    .build();
        }


        /*
        로그인 시
         */
        else {
            List<MappingUserInterest> mappingUserInterestsList = userRepository.findByUserID(getUserFromJWT().getUserID()).getUserInterests();




            for(MappingUserInterest userInterest:mappingUserInterestsList){

//                mappingStudyInterestRepository.findByInterest(interestRepository.findByInterestID(userInterest.getInterest().getInterestID()));


//                StudyDto.ReadStudyList.builder()
//                        .category(userInterest.getInterest().getInterestName())
//                        .title()




            }
















            return ReadStudyListDto.builder()
                    .loginUserDto(getUserFromJWT())
//                .readStudyList()
                    .build();
        }


    }


    /**
     * 스터디페이지 상세보기
     */
    public ReadStudyDetailDto readStudyDetail(Long studyID) {

        Study study = studyRepository.findByStudyID(studyID);

        // 스터디 InterestName List
        List<String> interestNameList = study.getStudyInterests().stream()
                .map(mappingStudyInterest -> mappingStudyInterest.getInterest())
                .map(Interest::getInterestName)
                .collect(Collectors.toList());


        // 스터디 승인받은 사람 수

        Long approvePeople = study.getStudyGuests().stream()
                .map(MappingStudyGuest::getStatus)
                .filter(s -> s.contentEquals("승인"))
                .count();


        // 스터디 멤버 현황 (승인/대기 받은사람 정보)
        List<MappingStudyGuest> mappingStudyGuestList = mappingStudyGuestRepository.findByStudy(study);


        List<StudyDto.ReadStudyDetailMember> readStudyDetailMembers = new ArrayList<>();

        for (MappingStudyGuest mappingStudyGuest : mappingStudyGuestList) {
            if (mappingStudyGuest.getStatus().contentEquals("승인") || mappingStudyGuest.getStatus().contentEquals("대기")) {
                readStudyDetailMembers.add(StudyDto.ReadStudyDetailMember.builder()
                        .nickname(mappingStudyGuest.getUser().getNickname())
                        .status(mappingStudyGuest.getStatus())
                        .build());
            }

        }


        return ReadStudyDetailDto.builder()
                .loginUserDto(getUserFromJWT())
                .readStudyDetail(StudyDto.ReadStudyDetail.builder()
                        .title(study.getTitle())
                        .hostNickName(study.getUser().getNickname())
                        .title(study.getTitle())
                        .approvePeople(approvePeople)
                        .needPeople(study.getNeedPeople())
                        .interestName(interestNameList)
                        .periodStart(study.getPeriodStart())
                        .periodEnd(study.getPeriodEnd())
                        .goal(study.getGoal())
                        .need(study.getNeed())
                        .onoffline(study.getOnoffline())
                        .details(study.getDetails())
                        .build())
                .readStudyDetailMembers(readStudyDetailMembers)
                .build();

    }

    /**
     * 스터디 참여 신청하기
     */
    public void applyStudyMember(Long studyID) {
        /*
        mappingStudyGuestTB 입력
         */
        MappingStudyGuest mappingStudyGuest = StudyGuestMapper.INSTANCE.toEntity(
                StudyGuestDto.builder()
                        .user(userRepository.findByUserID(getUserFromJWT().getUserID()))
                        .study(studyRepository.findByStudyID(studyID))
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
//        createStudyEntity.setHostID(1000L);
        createStudyEntity.setNeed("원하는거");
        createStudyEntity.setOnoffline("온라인");
        createStudyEntity.setPeriodStart(LocalDate.now());
        createStudyEntity.setPeriodEnd(LocalDate.now());
        createStudyEntity.setTitle("제목2");


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
