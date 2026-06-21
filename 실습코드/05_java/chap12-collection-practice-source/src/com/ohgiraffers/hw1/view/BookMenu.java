package com.ohgiraffers.hw1.view;
import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import java.util.List;
import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);
    BookDTO bookDTO;
    BookManager bm = new BookManager();

    public BookMenu(){

    }

    public void BookMenu(){

    }

    public void mainMenu(){


        while(true){
            System.out.print("*** 도서 관리 프로그램 ***\n" +
                    "1. 새 도서 추가\n" +
                    "2. 도서정보 정렬 후 출력\n" +
                    "3. 도서 삭제\n" +
                    "4. 도서 검색출력\n" +
                    "5. 전체 출력\n" +
                    "6. 끝내기\n"+
                    "메뉴 번호 입력 : ");
            int keyboard = sc.nextInt();

            switch (keyboard){
                case 1 :
                    bm.addBook(inputBook());
                    break;
                case 2 :
                    bm.printBookList(selectSortedBook());
                    break;
                case 3 :
                    bm.deleteBook(inputBookNo());
                    break;
                case 4 :
                    bm.searchBook(inputBookTitle());
                    break;
                case 5 :
                    bm.displayAll();
                    break;
                case 6 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    public BookDTO inputBook(){
        System.out.println("! 입력 할 책 정보를 입력해주세요.");
        System.out.print("도서 카테고리(1.인문/2.자연과학/3.의료/4.기타)  *번호만 입력 : ");
        int category = sc.nextInt();
        System.out.print("도서 제목 : ");
        String title = sc.next();
        System.out.print("도서 저자 : ");
        String author = sc.next();

        return new BookDTO(category, title, author);
    }

    public int inputBookNo(){
        System.out.print("! 삭제할 책 정보를 입력해주세요. : ");
        int keyword = sc.nextInt();
        return keyword;
    }

    public String inputBookTitle(){
        System.out.println("! 검색할 책 정보를 입력해주세요. : ");
        String keyword = sc.next();

        return keyword;
    }

    public List<BookDTO> selectSortedBook(){
        // 도서 정렬방식을 정수로 입력받아서
        // 1. 도서번호(ISBN)으로 오름차순정렬
        // 2. 도서번호(ISBN)으로 내림차순정렬
        // 3. 책 제목으로 오름차순 정렬
        // 4. 책 제목으로 내림차순 정렬
        // 객체의 sortedBookList() 메소드를 이용하여 출력
        System.out.print("1. 도서번호(ISBN)으로 오름차순정렬\n" +
                "2. 도서번호(ISBN)으로 내림차순정렬\n" +
                "3. 책 제목으로 오름차순 정렬\n" +
                "4. 책 제목으로 내림차순 정렬\n" +
                "정렬 할 순서 입력 : ");
        int type = sc.nextInt();

        return bm.sortedBookList(type);
    }

}
