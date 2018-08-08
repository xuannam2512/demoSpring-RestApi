package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.model.UserEntity;

@Service
public class UserServiceImpl implements UserService
{
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao; 
    }
    
    @Override
    public UserEntity findUserById(int id)
    {        
        return userDao.findById(id).get();
    }
    
    
    @Override
    public List<UserEntity> findAllUser()
    {              
        return userDao.findAll();
    }
    
    @Override
    public UserEntity Create(UserEntity userEntity) {
        return userDao.save(userEntity);
    }
    
    @Override
    public UserEntity updateUser(Integer id, UserEntity userEntity) {
        UserEntity existUser = userDao.findById(id).get();
        
        if(existUser != null) {
            existUser.setUsername(userEntity.getUsername());
            existUser.setPassword(userEntity.getPassword());
        }
        
        return userDao.save(existUser);
    }
    
    @Override
    public List<UserEntity> deleteUser(Integer id) {
        UserEntity userEntity = userDao.findById(id).get();
        userDao.delete(userEntity);
        return userDao.findAll();
    }
    
}
