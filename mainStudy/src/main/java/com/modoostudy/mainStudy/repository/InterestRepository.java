package com.modoostudy.mainStudy.repository;

import com.modoostudy.mainStudy.entity.Interest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest,Integer> {


    @Override
    List<Interest> findAll(Sort sort);

    Interest findByInterestID(Long interestID);



}
