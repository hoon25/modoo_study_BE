package com.modoostudy.mainStudy.repository;

import com.modoostudy.mainStudy.entity.MappingStudyInterest;
import com.modoostudy.mainStudy.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {

    Study findByStudyID(Long studyID);




}
