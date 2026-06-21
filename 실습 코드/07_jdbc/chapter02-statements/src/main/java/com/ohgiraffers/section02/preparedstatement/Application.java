package com.ohgiraffers.section02.preparedstatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.Application.close;

public class Application {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rset = null;

        try {

            //prepareStatement 수행 객체를 전달
            pstmt = con.prepareStatement("SELECT MENU_NAME FROM TBL_MENU");

            rset = pstmt.executeQuery();

            while(rset.next()){
                System.out.println(rset.getString("MENU_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(rset);
            close(pstmt);
            close(con);

        }

    }
}
