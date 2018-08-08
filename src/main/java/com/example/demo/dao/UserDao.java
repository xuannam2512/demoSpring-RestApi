package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.model.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer>
{
}
