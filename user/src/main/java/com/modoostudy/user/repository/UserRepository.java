package com.modoostudy.user.repository;

import com.modoostudy.user.domain.userTB;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<userTB, Long> {

//    @EntityGraph(attributePaths = {"certifiTB"}, type = EntityGraph.EntityGraphType.LOAD)
//    Optional<userTB> customfind(Long userId);
}
