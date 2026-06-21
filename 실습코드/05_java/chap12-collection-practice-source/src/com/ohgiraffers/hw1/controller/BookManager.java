package com.ohgiraffers.hw1.controller;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import java.util.*;

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
        for(int i=0; i<booklist.size(); i++){
            if(booklist.get(i).getbNo() == index){
                booklist.remove(i);
            }
        }
    }
    public void searchBook(String btitle){
        if( !booklist.contains(btitle)){
            System.out.println("'"+btitle+"' 도서를 찾았습니다.");
        }else{
            System.out.println("조회된 도서가 목록에 없습니다");
        }
    }
    public void displayAll(){
        System.out.println("도서 전체 갯수 : "+booklist.size());
        for(int i = 0 ; i < booklist.size() ; i++){
            System.out.println(booklist.get(i));
        }
    }
    public List<BookDTO> sortedBookList(int type){
        switch (type) {
            case 1:
                Collections.sort(booklist, new Comparator<BookDTO>(){
                    @Override
                    public int compare(BookDTO b1, BookDTO b2){
                        return Integer.compare(b1.getbNo(), b2.getbNo());
                    }
                });
                break;
            case 2:
                Collections.sort(booklist, new Comparator<BookDTO>(){
                    @Override
                    public int compare(BookDTO b1, BookDTO b2){

                        return Integer.compare(b2.getbNo(), b1.getbNo());
                    }
                });
                break;
            case 3:
                Collections.sort(booklist);
                break;
            case 4:
                Collections.sort(booklist, Collections.reverseOrder());
                break;
        }
        return booklist;
    }
    public void printBookList(List<BookDTO> printList){

        System.out.println("정렬된 도서 전체 갯수 : "+printList.size());
        for(int i = 0 ; i < printList.size() ; i++){
            System.out.println(printList.get(i));
        }
    }

}
