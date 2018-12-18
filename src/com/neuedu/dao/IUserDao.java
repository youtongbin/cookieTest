package com.neuedu.dao;

import com.neuedu.pojo.User;

public interface IUserDao {
    public int insert(User user);
    User getOne(String username);
}
