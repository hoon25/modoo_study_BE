package com.modoostudy.OAuth2.repository;

import com.modoostudy.OAuth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByGEmail(String GEmail);

}



