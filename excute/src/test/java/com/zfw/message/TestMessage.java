package com.zfw.message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mll.utils.MyHttpUtil;
import org.testng.reporters.jq.Main;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: yifei
 * @Date: 2018/11/27 17:42
 */
public class TestMessage {
    public static void main(String[] args) throws IOException {

 String url="http://api-octest.ca-b2b.com/oc/login";
        HashMap params=new HashMap();
        params.put("userName","admin");
        params.put("password","123456");
        String result=MyHttpUtil.httpPostRequest(url,params);
        System.out.println(result);
        JSONObject object=JSONObject.parseObject("{\"sender\":\"admin\",\"messageTypeId\":\"system\",\"userTypeId\":\"all\",\"zh\":{\"content\":\"<p>eeeee</p>\",\"title\":\"geeee\"},\"en\":{\"content\":\"<p>eeeee</p>\",\"title\":\"eeee\"}}");
        System.out.println(object.toJSONString());
       String urlAddMessage="";
    }

}
