package com.modoostudy.OAuth2.mapper;

import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import com.modoostudy.OAuth2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface SignupUserMapper extends GenericMapper<SignupUserDto, User> {
    SignupUserMapper INSTANCE = Mappers.getMapper(SignupUserMapper.class);
}