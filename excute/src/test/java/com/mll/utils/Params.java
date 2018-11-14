package com.mll.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huyif
 * @Description: ${TODO}
 * @date 2018/11/5 22:07
 */
public class Params {
    public static void creatFile(Map params) throws IOException {
        StringBuilder builder=new StringBuilder();
        builder.append("user").append(",").append("password").append("\n");
        BufferedWriter writer=new BufferedWriter(new FileWriter("user.bat"));
        params.forEach((k,v)->{
            builder.append(k).append(",").append("v").append("\n");
        });
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) {

        String sql="select * from mysql";
        Map map=new HashMap();
        try {
            map=JdbcUtils.getResult(JdbcUtils.executeQuery(sql,null));
            System.out.println(map.toString());


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
