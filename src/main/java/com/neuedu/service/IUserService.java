package com.neuedu.service;

import com.neuedu.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> getLists();

    int insertOne(User user);

    int updateOne(User user);

    int delOne(User user);

    User getUser(int id);

    User getOne(String userName);
}
