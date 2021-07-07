package com.modoostudy.OAuth2.repository;

import com.modoostudy.OAuth2.model.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,String> {
    @Override
    List<Region> findAll(Sort sort);
}
