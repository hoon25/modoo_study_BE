package com.modoostudy.mainStudy.mapper;

import com.modoostudy.mainStudy.dto.StudyDto;
import com.modoostudy.mainStudy.entity.Study;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface StudyMapper extends GenericMapper<StudyDto, Study> {

    StudyMapper INSTANCE = Mappers.getMapper(StudyMapper.class );


}
