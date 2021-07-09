package com.modoostudy.mainStudy.mapper;


import com.modoostudy.mainStudy.dto.RegionDto;
import com.modoostudy.mainStudy.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegionMapper extends GenericMapper<RegionDto, Region> {
    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

}
