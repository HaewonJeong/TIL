package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Application 1 : JDBC 기본 연결하기 */
public class Application1 {
    public static void main(String[] args) {
        /*
        * Connection
        * - 자바 애플리케이션과 DB 사이에 만들어지는 "연결 통로"
        * - DrvierManager를 통해 DB 접속 정보를 전달하면 Connection 객체를 얻을 수 있다.
        * */

        Connection con = null;

        try {
            /*사용할 JDBC Driver 클래스를 로딩*/
            Class.forName("com.mysql.cj.jdbc.Driver");

            //DriverManager.getConnection(url, user, password) 어떤 DB & DBMS? 어떤 계정과 PW? 전달
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "ohgiraffers", "ohgiraffers");

            System.out.println("con = " + con);



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
