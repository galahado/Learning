package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    int insertUser();

    void updateUser();

    void deleteUser();

    User getUserById();

    List<User> getAllUsers();
}
