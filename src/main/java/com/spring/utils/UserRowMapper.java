package com.spring.utils;


import com.spring.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setUsername(resultSet.getString(1));
        user.setPassword(resultSet.getString(2));
        return user;
    }
}
