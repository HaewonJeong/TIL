package com.ohgiraffers.section02.preparedstatement;
import com.ohgiraffers.model.dto.EmployeeDTO;
import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.Application.close;

public class Application4 {

    public static void main(String[] args) {
        /*XML 파일에 별도로 입력 한 sql문을 통해 처리*/

        // Connection 선언
        Connection con = getConnection();
        // PreparedStatement 선언
        PreparedStatement pstmt = null;
        // Result Set 선언
        ResultSet rset = null;

        // EmployeeDTO 선언
        EmployeeDTO row = null;
        // List<EmployeeDTO> 선언
        List<EmployeeDTO> employeeList = null;
        // 사용자에게 성 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.print("조회 할 성을 입력하세요.: ");
        String empName = sc.nextLine();

        // Properties 객체 생성하고 파일 읽어오기
        Properties prop = new Properties();

        try(FileInputStream queryStream =
                    new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml")) {
            prop.loadFromXML(queryStream);

            String query = prop.getProperty("selectEmplyeeByFamilyName");
            System.out.println("query = " + query);

            try {
                //PreparedStatment 객체 생성
                pstmt = con.prepareStatement(query);
                //위치 홀더 값 설정
                pstmt.setString(1, empName);
                //쿼리 실행하여 ResultSet 값으로 반환 받기
                rset = pstmt.executeQuery();
                //while문 작성
                employeeList = new ArrayList<>();

                while (rset.next()){

                    row = new EmployeeDTO();

                    row.setEmail(rset.getString("EMAIL"));
                    row.setEmpId(rset.getString("EMP_ID"));
                    row.setEmpName(rset.getString("EMP_NAME"));
                    row.setSalary(rset.getInt("SALARY"));
                    row.setEmpNo(rset.getString("EMP_NO"));

                    employeeList.add(row);

                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        catch ( FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } //finally 구문 작성
        //List에 담긴 직원 목록 출력
        finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        for(EmployeeDTO emp : employeeList){
            System.out.println("- 검색결과: "+emp);
        }


    }
}
