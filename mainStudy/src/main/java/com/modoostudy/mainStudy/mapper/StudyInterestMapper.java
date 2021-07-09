package com.modoostudy.mainStudy.mapper;

import com.modoostudy.mainStudy.dto.StudyInterestDto;
import com.modoostudy.mainStudy.entity.MappingStudyInterest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface StudyInterestMapper extends GenericMapper<StudyInterestDto, MappingStudyInterest> {
    StudyInterestMapper INSTANCE = Mappers.getMapper(StudyInterestMapper.class );
}
