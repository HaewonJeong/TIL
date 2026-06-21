package com.ohgiraffers.section01.user_type;

public class Application {
    public static void main(String[] args) {

        // 이전까지 사용하던 자바의 기본 자료형들
        int age = 20;
        String name = "홍길동";

        /*
        * [사용자 정의 자료형 사용하기]
        * 1. 클래스(설계도)를 만든다. (Member.java)
        * 2. 'new' 연산자를 통해 설계도대로 실제 객체를 메모리에 생성한다.
        * 3. 생성된 객체의 주소값을 담을 변수(참조 변수)를 선언하고, 주소값을 저장한다.
        *
        * 자료형 변수명 = new 클래스명();
        * */

        Member member = new Member();  // Member 설계도를 보고 메모리(Heap)공간에 member 객체(인스턴스) 생성

        // 생성된 객체(인스턴스)의 필드(속성)에 값 대입
        // 객체의 필드에 접근할 때는 '.'(참조 연산자)를 사용한다.
        member.id = "user01";
        member.pwd = "pass01";
        member.name = "홍길동";
        member.age = 20;
        member.gender = '남';
        member.hobby = new String[]{"축구", "볼링", "테니스"};

        System.out.println(member.id);
        System.out.println(member.gender);
        System.out.print("Hobby : ");
        for(int i = 0; i < member.hobby.length; i++) {
            System.out.print(member.hobby[i] + " ");
        }



    }
}
