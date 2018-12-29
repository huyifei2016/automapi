package example.restassured;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SLF4JLogFactory;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author: yifei
 * @Date: 2018/12/1 10:37
 */
public class SaveCookieStore {

    private static Logger logger= LoggerFactory.getLogger(SaveCookieStore.class);

    public void writeCookieStoreToFile(CookieStore cookieStore) {

        if (cookieStore == null) {
            return;
        }

        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cookie.file"))

        ) {
            oos.writeObject(cookieStore);
            oos.flush();
        } catch (IOException e) {
            logger.info(e.getMessage());
            return;
        }

    }
    public void saveCookiesStore(CookieStore cookieStore)
    {
        BasicCookieStore basicCookieStore=new BasicCookieStore();


    }




}
