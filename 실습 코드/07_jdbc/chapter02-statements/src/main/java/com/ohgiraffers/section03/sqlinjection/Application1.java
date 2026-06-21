package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.Application.close;

public class Application1 {

    //private static String empId = "200";
    //private static String empName = "선동일";

    private static String empId = "210";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";
    //SQL Injection 발생
    //query = SELECT * FROM EMPLOYEE WHERE EMP_ID = '210' AND EMP_NAME = '' OR 1=1 AND EMP_ID = '200'
    //id 및 이름이 둘 다 맞아야 출력되는것이 의도이나,
    // OR 1=1 구문이 항상 참이어서, ID 200 사원이 출력됨

    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND EMP_NAME = '" + empName + "'";
        System.out.println("query = " + query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()){
                System.out.println(rset.getString("EMP_NAME")+"님 환영합니다.");
            }else{
                System.out.println("조회 할 정보가 없습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

    }

}
