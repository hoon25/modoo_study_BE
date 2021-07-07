package com.modoostudy.OAuth2.repository;

import com.modoostudy.OAuth2.entity.MappingUserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingUserInterestRepository extends JpaRepository<MappingUserInterest, Long> {


}
