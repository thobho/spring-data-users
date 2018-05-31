package com.sda.spring.tutorial.jpa;

import com.sda.spring.tutorial.jpa.domain.UserEntity;
import com.sda.spring.tutorial.jpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

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
    CommandLineRunner demo(UserRepository userRepository){
        return (args)->{

            UserEntity userEntity = new UserEntity();
            userEntity.setEmail("Mirek@Gmail.com");
            userEntity.setName("Mirek");


            Iterable<UserEntity> all = userRepository.findAll();

            all.forEach(System.out::println);

        };
    }
}