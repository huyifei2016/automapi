package com.mll.automapi;


import com.mll.domain.User;
import com.mll.service.UserRepository;
import com.mll.service.Userimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;






/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AppTest.class)
@ComponentScan(basePackages = {"com.mll.config"})
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private  User user;
    @Autowired
    private UserRepository userimpl;

    @org.junit.Test
    public void test1()
    {
        System.out.println(user.toString());
    }

    @org.junit.Test
    public void shouldAnswerWithTrue() throws Exception {
        if(userimpl==null)
        {
            throw new Exception("userimpl bunnengweikong ");
        }
        User user=new User();
        user.setId(1);
        user.setName("name");
        user.setEmail("eee@.com");
        System.out.println( userimpl.save(user));
    }
}
