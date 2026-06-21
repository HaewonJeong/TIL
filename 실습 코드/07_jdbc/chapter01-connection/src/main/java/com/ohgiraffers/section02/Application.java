package com.ohgiraffers.section02;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection(); //코드 작성 후 Alt+enter JDBC Template에 작성한 Static 메서드 import
        System.out.println("con = " + con);

        /*if(con != null){
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        close(con);
    }

    //자주 사용하는 close+예외처리 구문을 메서드화
    public static void close(Connection con){
        try {
            if(con != null && !con.isClosed()){ //con이 null이 아니고 닫혀있지 않은 상태가 아니라면
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
