package com.ohgiraffers.hw1.model.dto;
import java.util.Comparator;

public class BookDTO implements Comparable<BookDTO> {
    public static int count = 1000;
    int bNo;
    int category;
    String title;
    String author;

    public BookDTO() {
    }

    public BookDTO(int category, String title, String author) {
        this.bNo = count++;
        this.category = category;
        this.title = title;
        this.author = author;
    }

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "[책 정보]" +
                "bNo : " + bNo +
                ", category : " + category +
                ", title : '" + title + '\'' +
                ", author : '" + author + '\'';
    }

    public int compareTo(BookDTO bookdto){
        return this.title.compareTo(bookdto.title);
    }
}
