package com.modoostudy.OAuth2.repository;

import com.modoostudy.OAuth2.model.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,String> {
    @Override
    List<Region> findAll(Sort sort);
}
