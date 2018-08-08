package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.model.UserEntity;

public interface UserService
{
    UserEntity findUserById(int id);
    
    List<UserEntity> findAllUser();
    
    UserEntity Create(UserEntity userEntity);

    UserEntity updateUser(Integer id, UserEntity userEntity);

    List<UserEntity> deleteUser(Integer id);
}
