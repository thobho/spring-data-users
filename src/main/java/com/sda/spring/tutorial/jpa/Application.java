package com.sda.spring.tutorial.jpa;

import com.sda.spring.tutorial.jpa.domain.UserEntity;
import com.sda.spring.tutorial.jpa.repository.UserRepository;
import com.sda.spring.tutorial.jpa.service.UserService;
import com.sda.spring.tutorial.jpa.service.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.sda.spring.tutorial.jpa.service", "com.sda.spring.tutorial.jpa.web", "com.sda.spring.tutorial.jpa.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner demo(UserService userService){
        return (args)->{

            UserDto userDto= new UserDto();
            userDto.setEmail("Mirek@Gmail.com");
            userDto.setName("Mirek");

            userService.save(userDto);

            List<UserDto> allUsers = userService.getAllUsers();

            allUsers.forEach(System.out::println);

        };
    }
}