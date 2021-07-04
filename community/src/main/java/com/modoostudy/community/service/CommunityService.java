package com.modoostudy.community.service;

import com.modoostudy.community.domain.entity.communityTB;
import com.modoostudy.community.domain.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommunityService {
    // 생성자 주입
    private final CommunityRepository communityRepository;

    public communityTB findById(Long communityId) {
        System.out.println("service");
        System.out.println("----------" + communityRepository.findByCommunityID(communityId));
        return communityRepository.findByCommunityID(communityId);
        // 중복 검사 뭐..시기 기타 등등의 작업들
    }
}
