package com.modoostudy.user.repository;

import com.modoostudy.user.domain.MappingEmblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingEmblemRepository extends JpaRepository<MappingEmblem, Long> {
}
