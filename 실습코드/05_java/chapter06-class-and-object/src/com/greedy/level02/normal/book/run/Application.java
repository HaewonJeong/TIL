package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        //기본 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO1 = new BookDTO();
        System.out.println(bookDTO1.getTitle()+" "+bookDTO1.getPublisher()+" "+ bookDTO1.getAuthor()+bookDTO1.getPrice()+" "+bookDTO1.getDiscountRate());
        //필드 3가지를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO2 = new BookDTO("자바의 정석", "도우출판", "남궁성");
        System.out.println(bookDTO2.getTitle()+" "+bookDTO2.getPublisher()+" "+ bookDTO2.getAuthor()+" "+bookDTO2.getPrice()+" "+bookDTO2.getDiscountRate());
        //모든 필드를 초기화하는 생성자를 이용하여 인스턴스
        BookDTO bookDTO3 = new BookDTO("홍길동전", "활빈당", "허균", 5000000, 0.5);
        System.out.println(bookDTO3.getTitle()+" "+bookDTO3.getPublisher()+" "+ bookDTO3.getAuthor()+" "+bookDTO3.getPrice()+" "+bookDTO3.getDiscountRate());
    }
}
