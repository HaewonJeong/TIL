package com.ohgiraffers.section01;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        //1. 커넥션 객체 생성
        Connection con = getConnection();

        //쿼리를 운반하고 결과를 반환하는 객체
        Statement stmt = null;

        //select 결과집합을 받아 올 용도의 객체
        ResultSet rset = null;

        try {
            //connection을 이용하여 statement(쿼리를 싣고 다닐 객체) 생성
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT MENU_NAME, MENU_PRICE FROM TBL_MENU");

            while(rset.next()){
                //next() : ResultSet의 다음 행을 보며 행이 존재하면 true, 존재하지 않으면 false 반환
                //커서 동작
                //next() 메서드는 커서를 무조건 한 칸 아래로 전진시킵니다. 그리고 이동한 위치에 따라 영리하게 행동합니다.
                //이동한 곳에 데이터가 있다면? 👉 true를 반환하고 while문 안으로 진입합니다.
                //이동한 곳에 데이터가 없다면? (끝에 도달) 👉 false를 반환하고 while문을 종료합니다.

                //getXXX() :
                //ResultSet에서 데이터를 가져올 때 사용.
                //데이터베이스 테이블에 저장된 컬럼의 타입에 맞춰 자바 프로그램으로 값을 읽어오는 역할


                System.out.println( rset.getString("MENU_NAME") + ", "
                                   + rset.getInt("MENU_PRICE") );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*맨 마지막에 항목부터 순서부터 닫아줌*/
            close(rset);
            close(stmt);
            close(con);
        }

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
