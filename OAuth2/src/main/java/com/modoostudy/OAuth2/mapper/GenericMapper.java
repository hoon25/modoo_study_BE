package com.modoostudy.OAuth2.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper <Dto, Entity>{

    Entity toEntity(Dto dto);
    Dto toDto(Entity entity);
    List<Entity> toEntity(List<Dto> dto);
    List<Dto> toDto(List<Entity> entity);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateFormDto(D dto, @MappingTarget E entity);
}
