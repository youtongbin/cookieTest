package com.neuedu.service;

import com.neuedu.pojo.User;

public interface IUserService {
    public int insert(User user);
    User getOne(String username);
}
