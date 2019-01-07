package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getLists();

    int insertOne(User user);

    int updateOne(User user);

    int delOne(User user);
}
