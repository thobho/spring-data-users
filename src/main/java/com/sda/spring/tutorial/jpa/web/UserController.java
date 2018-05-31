package com.sda.spring.tutorial.jpa.web;

import com.sda.spring.tutorial.jpa.domain.UserEntity;
import com.sda.spring.tutorial.jpa.repository.UserRepository;
import com.sda.spring.tutorial.jpa.service.UserService;
import com.sda.spring.tutorial.jpa.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {


        UserDto n = new UserDto();
        n.setName(name);
        n.setEmail(email);
        boolean isSaved = userService.save(n);

        return isSaved ? "Saved" : "Not Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}