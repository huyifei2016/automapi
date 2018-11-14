package com.mll.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mll.domain.User;
import com.mll.com.mll.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.mll.config"})
public class DatasourceConfig {
    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;
    @Bean
    public UserRepository UserImpl()
    {
        UserRepository userimpl=new Userimpl();
        return userimpl;
    }
    @Bean
    public JdbcTemplate JdbcTemplate()
    {


        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public User user()
    {
        User user=new User();
        user.setEmail("eeeee@.com");
        user.setName("name");
        user.setId(222);
        return user;
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");//用户名
        dataSource.setPassword("huyifei127");//密码
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }
    public static void main(String[] args) {
        SpringApplication.run(DatasourceConfig.class, args);
    }

}
