package com.ohgiraffers.section01.connection;
import com.mysql.cj.jdbc.Driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* Application 2 : 프로퍼티 파일을 불러와서 JDBC 연결 하는 방법*/
public class Application2 {
    public static void main(String[] args) {

        Properties prop = new Properties(); //설정 파일 전용 Map Collection
        Connection con = null;

        //프로퍼티의 파일의 내용을 읽어서 객체에 받는다.
        try(FileReader reader = new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"))
        {
            prop.load(reader); //Properties 파일 내부의 내용을 읽어 prop 객체에 담는다.
            System.out.println("prop!");

            String driver = prop.getProperty("driver"); //key 이름으로 value 값을 꺼내 온다.
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);

            System.out.println(con);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null){
                try {
                    if(!con.isClosed()){
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
