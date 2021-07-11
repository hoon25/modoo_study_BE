package com.modoostudy.user.repository;

import com.modoostudy.user.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserID(Long userID);

//    @Query("SELECT u FROM User u WHERE u.userID = ?1")
//    Optional<User> finduserTBByID(Long userID);
//
//    @Query("SELECT u FROM Certification u WHERE u.userID = ?1")
//    List<Certification> findUserCertificationById(Long userID);
//
//    @Query("SELECT u FROM Notification u WHERE u.userID = ?1")
//    List<Notification> findNotisById(Long userID);


//    @Query("SELECT u FROM MappingEmblem u WHERE u.userID = ?1")
//    List<MappingEmblem> findEmblemById(Long userID);
}
