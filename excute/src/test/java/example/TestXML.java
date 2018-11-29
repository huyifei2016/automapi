package example;

import com.mll.domain.User;
import com.mll.utils.XMLUtil;
import org.testng.annotations.Test;

/**
 * @Author: yifei
 * @Date: 2018/11/22 13:33
 */
public class TestXML {

    @Test
    public void TestXmlToObject()
    {
        String filePath="src/test/resources/User.xml";
        User user= (User) XMLUtil.convertXmlFileToObject(User.class,filePath);
        System.out.println(user);
    }


}
