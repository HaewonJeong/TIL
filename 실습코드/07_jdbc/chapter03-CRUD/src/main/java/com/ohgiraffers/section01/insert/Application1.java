package com.ohgiraffers.section01.insert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        //DML 작업 시에는 DML 작업이 일어난 행(row)의 갯수를 반환(int)
        int result = 0;

        Properties prop = new Properties();

        try(FileInputStream queryStream
                    = new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml")) {
            prop.loadFromXML(queryStream);
            String query = prop.getProperty("insertMenu");

            System.out.println("query = " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "봉골래청국장2");
            pstmt.setInt(2, 13000);
            pstmt.setInt(3, 1);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate(); //삽입 구문

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }
        System.out.println("result = " + result); // 결과가 일어난 행의 갯수를 반환한다.


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

    //자주 사용하는 close+예외처리 구문을 메서드화
    public static void close(Statement stmt){
        try {
            if(stmt != null && !stmt.isClosed()){ //con이 null이 아니고 닫혀있지 않은 상태가 아니라면
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //자주 사용하는 close+예외처리 구문을 메서드화
    public static void close(ResultSet rset){
        try {
            if(rset != null && !rset.isClosed()){ //con이 null이 아니고 닫혀있지 않은 상태가 아니라면
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
