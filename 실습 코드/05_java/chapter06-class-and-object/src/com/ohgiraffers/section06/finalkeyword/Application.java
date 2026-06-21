package com.ohgiraffers.section06.finalkeyword;

public class Application {
    public static void main(String[] args) {
        //final 변수 - 읽기만 가능, 변경 불가
        System.out.println("원주율: "+ MathConstant.PI);
        //MathConstant.PI = 3.14; //final 변수 PI에 값을 대입 할 수 없습니다.

        //final 인스턴스 필드
        Person person = new Person("000000-1111111", "홍길동");
        person.setName("홍길동 주니어");
        //person.ssn = "010101-2222222"; //final 필드 변경 불가

        //final 메서드 - 호출은 가능, 오버라이딩만 불가
        Child child = new Child();
        child.coreMethod();

    }

}
