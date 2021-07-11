package com.modoostudy.user.service;

import com.modoostudy.user.domain.Emblem;
import com.modoostudy.user.domain.MappingEmblem;
import com.modoostudy.user.domain.User;
import com.modoostudy.user.dto.EmblemDto;
import com.modoostudy.user.repository.EmblemRepository;
import com.modoostudy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class EmblemService {

    @Autowired
    private final UserRepository userRepository;
    private final EmblemRepository emblemRepository;

    public EmblemService(UserRepository userRepository, EmblemRepository emblemRepository) {
        this.userRepository = userRepository;
        this.emblemRepository = emblemRepository;
    }

    public List getEmblem(Long userID) {
        User user = userRepository.findByUserID(userID);
        List emblems = new ArrayList();

        Stream<MappingEmblem> emblemStream = user.getUserEmblemList().stream();
        emblemStream.forEach(x ->  emblems.add(EmblemDto.builder()
                .emblemID(x.getEmblem().getEmblemID())
                .emblemName(x.getEmblem().getEmblemName())
                .emblemUsed(x.getIsUsed()).build())
        );

        return emblems;
    }

    public List getAllEmblem(Long userID) {
        User user = userRepository.findByUserID(userID);
        List own = new ArrayList();

        Stream<MappingEmblem> emblemStream = user.getUserEmblemList().stream();
        emblemStream.forEach(x ->  own.add(x.getEmblem().getEmblemID()));
        System.out.println(own);

        List<Emblem> emblemList = emblemRepository.findAll();
        List allEmblems = new ArrayList();

        Stream<Emblem> emblemAll = emblemList.stream();
        emblemAll.forEach(x -> {
            if(own.contains(x.getEmblemID())){
                allEmblems.add(EmblemDto.builder()
                        .emblemName(x.getEmblemName())
                        .emblemOwn(1).build());
            }
            else {
                allEmblems.add(EmblemDto.builder()
                        .emblemName(x.getEmblemName())
                        .emblemOwn(0).build());
            }

        });
        return allEmblems;
    }
}
