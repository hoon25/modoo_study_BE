package com.modoostudy.user.repository;

import com.modoostudy.user.domain.Emblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmblemRepository extends JpaRepository<Emblem, Long> {

}
