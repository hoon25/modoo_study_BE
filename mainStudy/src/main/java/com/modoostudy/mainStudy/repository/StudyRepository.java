package com.modoostudy.mainStudy.repository;

import com.modoostudy.mainStudy.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {

    Study findByStudyID(Long studyID);



}
