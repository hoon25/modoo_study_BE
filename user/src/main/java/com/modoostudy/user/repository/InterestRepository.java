package com.modoostudy.user.repository;

import com.modoostudy.user.domain.MappingUserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<MappingUserInterest, Long> {

}
