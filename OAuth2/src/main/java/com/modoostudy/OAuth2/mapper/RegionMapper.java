package com.modoostudy.OAuth2.mapper;


import com.modoostudy.OAuth2.dto.signupForm.RegionDto;
import com.modoostudy.OAuth2.model.Region;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegionMapper extends GenericMapper<RegionDto, Region> {
    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

}
