package com.modoostudy.OAuth2.mapper;

import com.modoostudy.OAuth2.dto.signup.SignupUserInterestDto;
import com.modoostudy.OAuth2.entity.MappingUserInterest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface SignupUserInterestMapper extends GenericMapper<SignupUserInterestDto, MappingUserInterest> {
    SignupUserInterestMapper INSTANCE = Mappers.getMapper(SignupUserInterestMapper.class);
}
