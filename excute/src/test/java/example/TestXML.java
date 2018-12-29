package example;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.mll.domain.User;
import com.mll.utils.XMLUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yifei
 * @Date: 2018/11/22 13:33
 */
public class TestXML {



    @DataProvider(name = "username1")
    public Iterable<User> getUsers()
    {
        List<User> users=new ArrayList<>();


        return null;
    }

    @Test
    public void TestXmlToObject()
    {
        String filePath="src/test/resources/data/User.xml";
        System.out.println(filePath);
        User user= (User) XMLUtil.convertXmlFileToObject(User.class,filePath.toString());
        System.out.println(user);
    }


}
