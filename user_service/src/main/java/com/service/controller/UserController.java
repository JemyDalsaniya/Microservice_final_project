package com.service.controller;

import com.service.ValueObjects.ResponseTemplateVO;
import com.service.entity.UserEntity;
import com.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        log.info("Inside saveDepartment method of userController");
        System.out.println("inside user controller method");
        return  userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
