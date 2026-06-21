package com.ohgiraffers.section04.run;
import com.ohgiraffers.model.dao.MenuDAO;
import com.ohgiraffers.model.dto.CategoryDTO;
import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.section01.insert.Application1.close;

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection();
        MenuDAO menuDAO = new MenuDAO();

        /*1. 카테고리 조회*/
        List<CategoryDTO> categoryList = menuDAO.selectAllCategory(con);

        System.out.println("등록 가능한 카테고리 ");
        for(CategoryDTO categoryDTO : categoryList){
            System.out.println(categoryDTO.getCategoryCode() + " : "+ categoryDTO.getCategoryName());
        }

        /*신규 메뉴 등록*/
        Scanner sc = new Scanner(System.in);
        System.out.println("등록할 메뉴 이름:");
        String menuName = sc.nextLine();
        System.out.println("메뉴 가격:");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드:");
        int categoryCode = sc.nextInt();
        System.out.println("바로 판매 메뉴에 적용하겠습니까?(Y/N)");
        sc.nextLine(); //개행 제거
        String answer = sc.nextLine();

        String orderableStatus = answer.equals("Y") ? "Y" : "N";

        /*신규 메뉴 등록을 위한 메소드 호출*/
        MenuDTO newMenu = new MenuDTO(menuName, menuPrice, categoryCode, orderableStatus);

        int result = menuDAO.insertNewMenu(con, newMenu);

        if(result > 0 ){
            System.out.println("신규 메뉴 등록 완료");
        }else{
            System.out.println("메뉴 등록 실패 ㅠㅠ");
        }

        close(con);



    }

}
