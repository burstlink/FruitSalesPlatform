package com.springmvclearn.dao.impl;

import com.springmvclearn.dao.UserDao;
import com.springmvclearn.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    /*
     * 设置命名空间
     */
    public UserDaoImpl() {
        super.setNs("com.springmvclearn.mapper.UserMapper");
    }
}
