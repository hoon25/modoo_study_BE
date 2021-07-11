package com.modoostudy.user.mapper;

import com.modoostudy.user.domain.User;
import com.modoostudy.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends EntityMapper<UserDto, User>{
}
