package com.hw1.view;

import com.hw1.controller.LibraryManager;
import com.hw1.model.dto.Member;

import java.util.Scanner;

public class LibraryMenu {
    LibraryManager lm = new LibraryManager();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
//        // 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("나이: ");
        int age = sc.nextInt();
        System.out.print("성별: ");
        char sex = sc.next().charAt(0);
        Member member = new Member(name,age,sex);

//       // LibraryManager의 insertMember() 메소드에 전달
        lm.insertMember(member);
//        ==== 메뉴 ==== // 무한 반복 실행
//        1. 마이페이지 // LibraryManager의 myInfo() 호출하여 출력
//        2. 도서 전체 조회 // LibraryMenu의 selectAll() 호출
//        3. 도서 검색 // LibraryMenu의 searchBook() 호출
//        4. 도서 대여하기 // LibraryMenu의 rentBook() 호출
//        0. 프로그램 종료하기

        while(true){

        }
    }

    public void selectAll(){}
    public void searchBook(){}
    public void rentBook(){}
}
