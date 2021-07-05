package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.model.User;
import com.modoostudy.mainStudy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){

        System.out.println("service");
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

}
