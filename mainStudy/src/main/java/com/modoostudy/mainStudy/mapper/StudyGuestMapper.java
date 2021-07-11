package com.modoostudy.mainStudy.mapper;

import com.modoostudy.mainStudy.dto.StudyGuestDto;
import com.modoostudy.mainStudy.entity.MappingStudyGuest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface StudyGuestMapper extends GenericMapper<StudyGuestDto, MappingStudyGuest> {
    StudyGuestMapper INSTANCE = Mappers.getMapper(StudyGuestMapper.class );

}
