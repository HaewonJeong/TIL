package com.ohgiraffers.hw1.controller;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManager {

    List<BookDTO> booklist = new ArrayList<BookDTO>();
    Scanner sc = new Scanner(System.in);

    public void BookManager(){
        this.booklist = booklist;
    }
    public void addBook(BookDTO book){
        //전달받은 도서정보를 필드에 선언한 List에 담는다.
        booklist.add(book);
    }
    public void deleteBook(int index){
        booklist.remove(index);
    }
    public void searchBook(String btitle){
        if( !booklist.contains(btitle)){
            System.out.println(btitle+" 도서를 찾았습니다.");
        }else{
            System.out.println("조회된 도서가 목록에 없습니다");
        }
    }
    public void displayAll(){
        for(int i = 0 ; i < booklist.size() ; i++){
            System.out.println("도서 전체 갯수 : "+booklist.size());
            System.out.println(booklist.get(i));
        }
    }
    public List<BookDTO> sortedBookList(int type){
        switch (type) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                Collections.sort(booklist);
                break;
            case 4:
                break;
        }
        return booklist;
    }
    public void printBookList(List<BookDTO> printList){
        for(int i = 0 ; i < printList.size() ; i++){
            System.out.println("정렬된 도서 전체 갯수 : "+printList.size());
            System.out.println(printList.get(i));
        }
    }

}
