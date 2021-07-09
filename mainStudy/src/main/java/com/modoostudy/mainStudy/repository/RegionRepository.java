package com.modoostudy.mainStudy.repository;

import com.modoostudy.mainStudy.entity.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,String> {
    @Override
    List<Region> findAll(Sort sort);
}
