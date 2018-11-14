package com.mll.automapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger= LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        String location = null;
        Assert.notNull(location,"Location must not be null!");
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");
        System.out.println( "Hello World!" );
    }
}
