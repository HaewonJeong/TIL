package com.ohgiraffers.section01.object;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Book book1 = new Book(1, "홍길동전", "허균", 500000);
        Book book2 = new Book(2, "목민심서", "정약용", 300000);
        Book book3 = new Book(2, "목민심서", "정약용", 300000);


        //Object.toString() 기본 기능은 '클래스명@해시코드'를 반환
        //객체의 필드 값을 보여주도록 오버라이딩 하여 사용
        System.out.println("book1 =" + book1); //tostring이 문자열 반환

        /*
        * Object.quals()의 기본 기능은 '=='와 같이 두 객체의 주소값을 비교한다.(동일성 비교)
        * 하지만 떄로는 주소가 달라도 필드의 내용이 같으면 '같다(동등하다)'고 판단해야 할 때가 있다.
        * 이런 '동등성 비교'를 위해 equals()를 오버라이딩 한다.
        *
        * 해원 설명)
        * 자바의 모든 클래스는 부모인 Object 클래스로부터 equals를 물려받습니다.
        * 원래 Object가 가진 equals는 기본적으로 == 연산자와 똑같이 동작 합니다.
        * 즉, 해원님이 equals를 오버라이딩 함으로써,
        * 프로그램에게 "책 번호와 제목, 저자, 가격이 모두 같으면 같은 책으로 취급해라"라는 새로운 규칙을 알려준 것
        * */

        System.out.println("동일성 비교(==)" + (book2 == book3));
        System.out.println("동등성 비교"+ book2.equals(book3)); //동등성 비교를 위해 Override 한 후 결과 true로 바뀜

        /*자바의 중요한 규약 : equels() 비교로 true를 반환한다면,
        * 두 객체의 hashCode() 값은 반드시 같아야 한다.
        *
        * HashSet, HashMap 같은 해시 기반 컬렉션은 객체를 찾을 때 다음 순서로 찾는다.
        * 1. hashCode()로 어느칸을 찾아볼지 먼저 결정
        * 2. 같은 칸 안에서 equals()로 정말 같은 객체인지 최종 비교
        * 만약 equals는 true인데 hashCode가 다르면, 애초에 다른 칸을 보게 되므로 equals() 비교까지 도달하지 못함
        * */
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());

        Set<Book> books = new HashSet<>();
        books.add(book2);
        System.out.println("HashSet에서 book3 찾기 : " + books.contains(book3));
        //equals를 오버라이딩 시 결과값 true.


    }
}
