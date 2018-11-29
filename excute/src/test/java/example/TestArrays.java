package example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author: yifei
 * @Date: 2018/11/22 8:23
 */
public class TestArrays {

    @DataProvider(name = "examplearrays")
    public static Object[][] createLogin()
    {
        return new Object[][]{{"username","hhhhffff"}};
    }

    @Test(dataProvider = "examplearrays")
    public void  testddd(String username,String password)
    {
        System.out.println("username:"+username+"\n"+"passsword:"+password);
    }

}
