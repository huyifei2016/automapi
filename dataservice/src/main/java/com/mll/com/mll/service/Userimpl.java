package com.mll.com.mll.service;

import com.mll.config.UserMapper;
import com.mll.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Userimpl implements UserRepository {
@Autowired
   private JdbcTemplate jdbcTemplate;
    @Override
    public void findUserFormId(String id) {
    String sql="select * from user where id="+id;
     User user=jdbcTemplate.queryForObject(sql,new UserMapper());
    }
}
