package com.modoostudy.mainStudy.mapper;

import com.modoostudy.mainStudy.dto.InterestDto;
import com.modoostudy.mainStudy.entity.Interest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InterestMapper extends GenericMapper<InterestDto, Interest> {
    InterestMapper INSTANCE = Mappers.getMapper(InterestMapper.class );

}
