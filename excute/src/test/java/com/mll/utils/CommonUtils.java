package com.mll.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author huyif
 * @Description: ${TODO}
 * @date 2018/9/22 11:12
 */
public class CommonUtils {


    private static Logger LOG= LoggerFactory.getLogger(CommonUtils.class);
    private static Map<String,String> map = new HashMap<String,String>();

    static{
        Properties properties = new Properties();
        try{
            properties.load(CommonUtils.class.getResourceAsStream("/httpclient.properties"));
            Set<Map.Entry<Object, Object>> entries =  properties.entrySet();
            Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
            while(iterator.hasNext()){
                Map.Entry<Object, Object> entry = iterator.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                if(null != key && value != null ){
                    map.put(key.toString(), value.toString());
                }
            }
        }catch(Exception e){
            LOG.error("加载配置文件错误",e.fillInStackTrace());
        }
    }


    public static String getPropertiesValue(String key){

        return map.get(key);
    }

}
