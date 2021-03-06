package com.mll.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class JdbcUtils {

	 private static  Connection conn = null;
	   
	  private static   PreparedStatement ps = null;
	 private  static    ResultSet rs = null;
	
	    
	    public static void main(String[] args) {
			
	    	
	   
				JdbcUtils jj=new JdbcUtils();

		
		}
	    
	    static {
	    	
	    	
	    	
	    	conn=getConn(JdbcUtils.getJdbcValue("server"), JdbcUtils.getJdbcValue("dbname"), JdbcUtils.getJdbcValue("dbuser"), JdbcUtils.getJdbcValue("dbpwd"));
	    	
	    }
	public static String getJdbcValue(String key)
	{
		Properties pro=new Properties();
		//    InputStream files=JdbcUtils.class.getResourceAsStream("src/main/resource/jdbc.properties");
		InputStream files=JdbcUtils.class.getResourceAsStream("/src/test/resources/jdbc.properties");
		try {
			pro.load(files);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String) pro.get(key);
	}
	    

    public static Connection getConn(String server,String dbname,String dbuser,String dbpwd){      
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://"+server+":3306/"+dbname+"?user="+dbuser+"&password="+dbpwd+"&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        try{
            Class.forName(DRIVER);  
            conn = DriverManager.getConnection(URL);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public int executeUpdate(String preparedSql,String[]param){
        int num = 0;
        try{
            ps = conn.prepareStatement(preparedSql);
            if(ps != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            num = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return num;
    }

    public static ResultSet executeQuery(String preparedSql,String[] param){
        try{
        
            ps = conn.prepareStatement(preparedSql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
                
            }
            System.out.println(preparedSql);
            rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }       
        return rs;

    }

	public static Map getResult(ResultSet rs) throws SQLException {
        Map params=new HashMap();
        if(rs!=null)
        {
            while (rs.next())
            {
                params.put(rs.getObject("user"),rs.getObject("password"));
            }


        }
        closeAll(rs,null,null);
        return params;
    }


    public static void closeAll(ResultSet rs,Connection con,PreparedStatement ps){
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            }
        }
        }
}
