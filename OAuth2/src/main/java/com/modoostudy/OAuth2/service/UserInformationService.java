//package com.modoostudy.OAuth2.service;
//
//
//
//import com.modoostudy.OAuth2.domain.User;
//import com.modoostudy.OAuth2.domain.UserInformation;
//import com.modoostudy.OAuth2.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class UserInformationService implements UserDetailsService {
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByGEmail(username);
//
//        // 저장된 ID가 없을 때 throw 시켜줍니다.
//        if(user == null) {
//            throw new UsernameNotFoundException("wrongID"); // 저장된 ID 없음
//        }
//
//        return makeLoginUser(user);
//
//    }
//
//    public UserInformation makeLoginUser(User user){
//
//        UserInformation loginUser = new UserInformation();
//
//        List<GrantedAuthority> Authoritylist = new ArrayList<>();
//
//        switch(user.getAuthorities()) {
//            case 0 :
//                Authoritylist.add(new SimpleGrantedAuthority("ADMIN"));
//
//            case 1 :
//                Authoritylist.add(new SimpleGrantedAuthority("USER"));
//                break;
//        }
//
//        loginUser.setUsername(user.getUserName());
//        loginUser.setPassword(user.getPassword());
//        loginUser.setAuthorities(Authoritylist);
//
//        return loginUser;
//
//    }
//}
