package example;

import com.mll.domain.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: yifei
 * @Date: 2018/11/22 8:58
 */
public class TestIterator {

    @DataProvider(name = "iterator1")
    public Iterator<String[]> getParameters()
    {
        Collection<String[]> arrays=new ArrayList<>();
        arrays.add(new String[]{"heee111"});
        arrays.add(new String[]{"heeee222"});
        return arrays.iterator();
    }



    @Test(dataProvider = "iterator1")
    public void testIterator(String[] name)
    {
        for (int i = 0; i < name.length; i++) {
            String s = name[i];
            System.out.println(s);
        }


    }


}
