package com.modoostudy.OAuth2.repository;

import com.modoostudy.OAuth2.model.Interest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest,Integer> {


    @Override
    List<Interest> findAll(Sort sort);



}
