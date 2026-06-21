package com.ohgiraffers.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();

        try (FileReader reader = new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties")) {
            prop.load(reader); //Properties 파일 내부의 내용을 읽어 prop 객체에 담는다.
            System.out.println("prop!!");

            String driver = prop.getProperty("driver"); //key 이름으로 value 값을 꺼내 온다.
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);
            //getConnection에 properties 객체를 전달 할 수도 있다.
            //단, properties 파일의 Key 이름이 정확해야 함.

            System.out.println(con);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*Connection을 사용하는 쪽으로 반환해야 하므로 여기서 Close 하지 않음*/
        return con;
    }
}
