package com.ohgiraffers.section02;
import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.insert.Application1.close;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 메뉴 번호를 입력하세요:");
        int menuCode = sc.nextInt();
        System.out.println("변경할 메뉴의 이름을 입력하세요:");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.println("변경할 메뉴의 가격을 입력하세요:");
        int menuPrice = sc.nextInt();

        MenuDTO changeMenu = new MenuDTO();
        changeMenu.setMenuCode(menuCode);
        changeMenu.setMenuName(menuName);
        changeMenu.setMenuPrice(menuPrice);

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        int result = 0;

        Properties prop = new Properties();

        try(FileInputStream queryStream = new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml")) {
            prop.loadFromXML(queryStream);

            String query = prop.getProperty("updateMenu");

            pstmt = con.prepareStatement(query);

            pstmt.setString(1, changeMenu.getMenuName());
            pstmt.setInt(2, changeMenu.getMenuPrice());
            pstmt.setInt(3, changeMenu.getMenuCode());

            result = pstmt.executeUpdate();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

        /*
        * executeUpdate()는 보통 이렇게 리턴해:
        1 : 업데이트 성공 (1행 변경됨)
        0 : 조건에 맞는 행이 없어서 아무것도 변경 안 됨
        -1 : JDBC에 따라 거의 안 나옴 (보통 안 씀)
        *
        * */
        if(result > 0){
            System.out.println("메뉴 변경 성공!");
        }else{
            System.out.println("메뉴 변경 실패!");
        }



    }

}
