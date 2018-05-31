package com.sda.spring.tutorial.jpa.service.internal;

import com.sda.spring.tutorial.jpa.domain.UserEntity;
import com.sda.spring.tutorial.jpa.repository.UserRepository;
import com.sda.spring.tutorial.jpa.service.UserService;
import com.sda.spring.tutorial.jpa.service.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        Iterable<UserEntity> all = userRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).map(entity->modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public boolean save(UserDto userDto) {
        UserEntity entity = modelMapper.map(userDto, UserEntity.class);
        UserEntity savedEntry = userRepository.save(entity);
        return savedEntry != null;
    }
}
