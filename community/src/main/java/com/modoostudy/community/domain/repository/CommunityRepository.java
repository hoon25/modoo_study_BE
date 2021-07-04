package com.modoostudy.community.domain.repository;

import com.modoostudy.community.domain.entity.communityTB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<communityTB, Long> {

    communityTB findByCommunityID(Long communityID);
}
