package com.sda.spring.tutorial.jpa.service;

import com.sda.spring.tutorial.jpa.service.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    boolean save(UserDto userDto);

}
