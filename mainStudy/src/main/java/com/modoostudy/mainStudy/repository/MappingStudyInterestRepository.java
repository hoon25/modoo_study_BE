package com.modoostudy.mainStudy.repository;

import com.modoostudy.mainStudy.entity.MappingStudyInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingStudyInterestRepository extends JpaRepository<MappingStudyInterest, Long> {

}
