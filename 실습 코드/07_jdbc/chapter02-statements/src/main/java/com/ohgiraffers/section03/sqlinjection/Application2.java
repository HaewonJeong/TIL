package com.ohgiraffers.section03.sqlinjection;

import java.sql.*;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.Application.close;

public class Application2 {

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
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";
        System.out.println("query = " + query);

        //query = SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?
        //조회 할 정보가 없습니다. 출력
        //PreparedStatement는 입력값을 SQL 문법이 아니라 데이터 값으로 다룬다.
        //따라서 입력값 안에 '이나 OR 조건이 포함되어 있어도 SQL 구조가 변형되지 않는다.


        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);

            rset = pstmt.executeQuery();

            if(rset.next()){
                System.out.println(rset.getString("EMP_NAME")+"님 환영합니다.");
            }else{
                System.out.println("조회 할 정보가 없습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

    }

}
