package com.modoostudy.mainStudy.repository;

import com.modoostudy.mainStudy.entity.MappingStudyGuest;
import com.modoostudy.mainStudy.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MappingStudyGuestRepository extends JpaRepository<MappingStudyGuest, Long> {

    List<MappingStudyGuest> findByStudy(Study study);


}
