package com.modoostudy.user.service;

import com.modoostudy.user.domain.MappingEmblem;
import com.modoostudy.user.domain.MappingUserInterest;
import com.modoostudy.user.domain.User;
import com.modoostudy.user.dto.ImageDto;
import com.modoostudy.user.dto.UserDto;
import com.modoostudy.user.mapper.UserMapper;
import com.modoostudy.user.repository.CertificationRepository;
import com.modoostudy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private UserMapper userMapper;


    public UserService(UserRepository userRepository, CertificationRepository certificationRepository) {
        this.userRepository = userRepository;
        this.certificationRepository = certificationRepository;
    }

    public List<User> allUser() {
        return userRepository.findAll();
    }

    public UserDto getUser(Long userID) {
        User user = userRepository.findByUserID(userID);

        return UserDto.builder()
                .userImage(user.getUserImage())
                .nickname(user.getNickname())
                .GEmail(user.getGEmail())
                .grade(1F)
                .emblem(getEmblem(userID))
                .region(user.getRegion())
                .interests(getInterest(userID))
                .certification(getCertification(userID))
                .build();
    }

    public List getCertification(Long userID) {
        return certificationRepository.findByUserID(userID);
    }

    public List getEmblem(Long userID) {
        User user = userRepository.findByUserID(userID);
        List emblem = new ArrayList();

        Stream<MappingEmblem> emblemStream = user.getUserEmblemList().stream();
        emblemStream.forEach(x -> {
            if(emblem.size() < 3) {
                emblem.add(x.getEmblem().getEmblemName());
            }
        });
        return emblem;
    }

    public List getInterest(Long userID) {
        User user = userRepository.findByUserID(userID);
        List interest = new ArrayList();

        Stream<MappingUserInterest> stream = user.getUserInterestList().stream();
        stream.forEach(x -> interest.add(x.getInterests().getInterestName()));

        return interest;
    }

    public ImageDto getUserImage(Long userID) {
        User user = userRepository.findByUserID(userID);
        ImageDto userImage = ImageDto.builder().userImage(user.getUserImage()).build();

        return userImage;
    }

    @Transactional
    public void updateImage(Long userID, String imageUrl) {
        User user = userRepository.findByUserID(userID);
        user.setUserImage(imageUrl);
    }
}
