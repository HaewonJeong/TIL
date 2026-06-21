package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        User user = new User(); // 기본 생성자 함수를 호출하는 구문
        System.out.println(user.getInformation());

        user.setId("user01");
        user.setPwd("pass01");
        user.setName("홍길동");
        System.out.println(user.getInformation());

        // 매개변수 있는 생성자 호출
        User user1 = new User("user02", "pass02", "유관순");
        System.out.println(user.getInformation());

        // 모든 필드를 초기화하는 생성자 호출
        User user2 = new User("user03", "pass03", "이순신", new Date());
        System.out.println(user2.getInformation());
    }
}
