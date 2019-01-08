package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getLists();

    User getUser(int id);

    User getOne(String userName);

    int insertOne(User user);

    int updateOne(User user);

    int delOne(User user);

    User selOne(int id);
}
