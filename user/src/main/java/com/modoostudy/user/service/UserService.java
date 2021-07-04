package com.modoostudy.user.service;

import com.modoostudy.user.domain.userTB;
import com.modoostudy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<userTB> allUser() {
        return userRepository.findAll();
    }

    public Optional<userTB> getUser(Long userID) {
        return userRepository.findById(userID);
    }
}
