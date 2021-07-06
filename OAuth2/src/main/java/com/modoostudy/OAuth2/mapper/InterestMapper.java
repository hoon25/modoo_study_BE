package com.modoostudy.OAuth2.mapper;

import com.modoostudy.OAuth2.dto.signupForm.InterestDto;
import com.modoostudy.OAuth2.model.Interest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InterestMapper extends GenericMapper<InterestDto, Interest> {
    InterestMapper INSTANCE = Mappers.getMapper(InterestMapper.class);

}
