package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.model.UserEntity;
import com.example.demo.service.UserService;

@RestController
public class UserController
{
    UserService userService;
    
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserEntity> getUsers()
    {
        List<UserEntity> users = userService.findAllUser();
        return users;
    }
    
    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public UserEntity getUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity register(@RequestBody(required = true) UserEntity userEntity) {                   
        return userService.Create(userEntity);
    }
    
    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public UserEntity updateUser(@PathVariable("id") Integer id, @RequestBody(required = true) UserEntity userEntity) {
        return userService.updateUser(id, userEntity);
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public List<UserEntity> deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUser(id);
    }
}
