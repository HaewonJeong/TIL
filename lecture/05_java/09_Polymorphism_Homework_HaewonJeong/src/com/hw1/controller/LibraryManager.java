package com.hw1.controller;

import com.hw1.model.dto.Book;
import com.hw1.model.dto.Member;

public class LibraryManager {
    private Member mem = new Member(null);
    private Book[] bList = new Book[5];

    public void insertMember(Member mem){};
    public Member myInfo(){
        return null;
    }
    public Book[] selectAll(){
        return null;
    }
    public Book[] searchBook(String keyword){
        return null;
    }
    public int rentBook(int index){
        return 0;
    }
}
