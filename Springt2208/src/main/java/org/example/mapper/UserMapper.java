package org.example.mapper;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class UserMapper {
    public static UserDto entityToDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
    public static User dtoToEntity(UserDto dto ) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
