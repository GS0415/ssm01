package com.neuedu.service;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;

    @Override
    public List<User> getLists() {
        return dao.getLists();
    }

    @Override
    public int insertOne(User user) {
        return dao.insertOne(user);
    }

    @Override
    public int updateOne(User user) {
        return dao.updateOne(user);
    }

    @Override
    public int delOne(User user) {
        return dao.delOne(user);
    }
}
