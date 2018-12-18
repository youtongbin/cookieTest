package com.neuedu.service;

import com.neuedu.dao.IUserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.pojo.User;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return userDao.getOne(username);
    }
}
