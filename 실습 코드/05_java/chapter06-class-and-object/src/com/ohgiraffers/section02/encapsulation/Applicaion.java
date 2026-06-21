package com.ohgiraffers.section02.encapsulation;

public class Applicaion {
    public static void main(String[] args) {

        Children child1 = new Children();
        child1.setAge(-10);     // setter 메소드로 나이 설정

        System.out.println("어린이 나이 : " + child1.getAge() + " 세" );

//        child1.age = -30; // private 필드이기 때문에 접근할수 없다
        System.out.println("어린이 나이 : " + child1.getAge() + " 세" );

    }
}
