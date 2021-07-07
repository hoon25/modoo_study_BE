package com.modoostudy.OAuth2.repository;

import com.modoostudy.OAuth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByGEmail(String GEmail);
    User findByUserID(String userID);
    User findByPassword(String password);
    User findByNickname(String nickName);

}



