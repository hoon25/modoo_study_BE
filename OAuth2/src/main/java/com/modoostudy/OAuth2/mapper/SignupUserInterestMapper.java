package com.modoostudy.OAuth2.mapper;

import com.modoostudy.OAuth2.dto.signup.SignupUserDto;
import com.modoostudy.OAuth2.dto.signup.SignupUserInterestDto;
import com.modoostudy.OAuth2.model.MappingUserInterest;
import com.modoostudy.OAuth2.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface SignupUserInterestMapper extends GenericMapper<SignupUserInterestDto, MappingUserInterest> {
    SignupUserInterestMapper INSTANCE = Mappers.getMapper(SignupUserInterestMapper.class);
}
