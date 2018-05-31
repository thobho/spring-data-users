package com.sda.spring.tutorial.jpa.repository;


import com.sda.spring.tutorial.jpa.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findAllByAgeLessThanAndNameIsLike(Integer maxAge, String nameLike);

}