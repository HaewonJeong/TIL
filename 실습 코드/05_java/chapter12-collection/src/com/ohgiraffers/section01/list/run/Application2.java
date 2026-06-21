package com.ohgiraffers.section01.list.run;
import com.ohgiraffers.section01.list.Comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        List<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO(1, "홍길동", "허균", 50000));
        bookList.add(new BookDTO(2, "삼국사기", "김부식", 46000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));

        /*
        * BookDTO 클래스에 Comparable 인터페이스를 구현하고 compareTo 메소드를 오버라이딩 했기 때문에
        * BookDTO 객체들은 기본 정렬 기준(책 번호 오름차순)을 가지게 되었다.
        * Collections.sort() 메소드는 별도의 정렬기준을 주지 않으면, 이 기본 정렬 기준을 사용한다.
        * */

        /*
        * Comparable = 객체 안에 기본 정렬 기준 1개를 심는다.
        * Comparator = 정렬할 때마다 외부에서 기준을 갈아 끼운다.
        * */

        System.out.println("Comparable/  오름차순 정렬");
        Collections.sort(bookList); //sort 구현해야 작동 됨
        for(BookDTO book : bookList){
            System.out.println(book);
        }

        System.out.println("Comparator/ 오름차순 정렬");
        bookList.sort(new AscendingPrice());
        for(BookDTO book : bookList){
            System.out.println(book);
        }

        System.out.println("Comparator 익명 클래스 사용 / 내림차순 정렬");
        //익명 클래스 사용(가격 내림차순)
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return Integer.compare(o2.getPrice(), o1.getPrice());
            }
        });
        System.out.println("람다식 사용 / 오름차순 정렬");
        //람다식 사용 (제목 오름차순)
        /*인터페이스에 메소드가 하나만 있는 경우, 익명 클래스 대신 람다식 사용 가능*/
        bookList.sort( (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        for(BookDTO book : bookList){
            System.out.println(book);
        }

    }
}

/*
1. 객체 정렬의 전제 조건
Collections.sort(List<T> list) 메서드는 매개변수로 받는 리스트의 요소 타입(T)이 반드시 Comparable 인터페이스를 구현하고 있어야만 작동합니다. 내부적으로 Timsort 알고리즘을 사용하며, 이 알고리즘은 정렬 과정에서 요소 간의 선후 관계를 결정하는 비교 연산이 필요하기 때문입니다.

2. 내부 동작 흐름 (Stack Trace 관점)
Collections.sort(bookList)를 호출하면 다음과 같은 순서로 실행됩니다.
타입 확인: 자바 컴파일러와 런타임은 BookDTO가 Comparable<BookDTO>를 implements 했는지 확인합니다.
비교 메서드 호출: 정렬 알고리즘이 리스트 내의 두 객체(예: book1, book2)를 선택합니다.
메서드 실행: 알고리즘 내부에서 book1.compareTo(book2)를 호출합니다.

반환값 분석:
반환값이 음수이면: book1이 book2보다 작다고 판단하여 앞에 배치합니다.
반환값이 양수이면: book1이 book2보다 크다고 판단하여 뒤에 배치합니다.
반환값이 0이면: 두 객체의 우선순위가 같다고 판단하여 현재 순서를 유지합니다.
* */