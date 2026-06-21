package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.Application.close;

public class Application2 {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 메뉴 번호를 입력:");
        String menuCode = sc.nextLine();

        /*? : 위치 홀더 - 값이 들어갈 위치를 표시*/
        // 1. 쿼리 틀을 미리 만들어 둡니다. (값이 들어갈 자리는 ? 로 비워둠)
        String query = "SELECT MENU_NAME FROM TBL_MENU WHERE MENU_CODE = ?";

        try {

            //prepareStatement 객체 생성 시 수행할 sql 구문을 인자로 생성하며 전달
            // 2. ? 자리에 실제 값을 매칭해 줍니다.
            pstmt = con.prepareStatement(query);
            /*sql문의 위치 홀더를 설정*/
            pstmt.setString(1, menuCode); //위치홀더(?)가 두개일때는 1~2로 줄 수 있다.
            //setString(1, menuCode):
            // 1 (첫 번째 매개변수): 쿼리문 전체를 왼쪽에서 오른쪽으로 읽었을 때 나오는 '몇 번째 물음표(?)인가'를 뜻합니다. 컴퓨터 기준(0부터 시작)이 아니라, SQL 직관성을 위해 1부터 시작합니다.
            //menuCode (두 번째 매개변수): 그 ? 자리에 쏙 집어넣을 실제 변수나 값입니다.

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
