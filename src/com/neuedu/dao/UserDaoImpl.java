package com.neuedu.dao;

import com.neuedu.pojo.User;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insert(User user) {
        return JdbcUtil.executeUpdate("insert into user(username,password,tele) values(?,?,?)",user.getUsername(),user.getPassword(),user.getTele());
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.getOne("select * from user where username = ?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User user = new User();
                try {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setTele(rs.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        },username);
    }
}
