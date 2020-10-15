package com.springmvclearn.service.impl;

import com.springmvclearn.dao.UserDao;
import com.springmvclearn.entity.User;
import com.springmvclearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    public List<User> find(Map map) {
        return userDao.find(map);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(Serializable id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        userDao.delete(ids);
    }
}
