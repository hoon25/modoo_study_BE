package com.modoostudy.mainStudy.service;

import com.modoostudy.mainStudy.entity.User;
import com.modoostudy.mainStudy.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public void getUserID() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);

        System.out.println(authentication.getName());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getClass());
        System.out.println(authentication.getPrincipal());




    }


}
