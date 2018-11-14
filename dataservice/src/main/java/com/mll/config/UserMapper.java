package com.mll.config;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setEmail(resultSet.getString(1));
        user.setId(resultSet.getInt(2));
        user.setName(resultSet.getString(3));

        return null;
    }
}
