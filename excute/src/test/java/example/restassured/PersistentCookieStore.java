package example.restassured;


import com.github.bleeding182.sharedpreferences.annotations.SharedPreference;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * @Author: yifei
 * @Date: 2018/11/30 13:06
 */
public class PersistentCookieStore implements CookieStore {


    SharedPreference cookiePrefs;


    @Override
    public void addCookie(Cookie cookie) {

    }

    @Override
    public List<Cookie> getCookies() {
        return null;
    }

    @Override
    public boolean clearExpired(Date date) {
        return false;
    }

    @Override
    public void clear() {

    }
}
