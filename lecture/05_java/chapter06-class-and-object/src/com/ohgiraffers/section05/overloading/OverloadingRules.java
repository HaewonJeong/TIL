package com.ohgiraffers.section05.overloading;

public class OverloadingRules {

    //1. 기본 생성자

    //2. 매개변수 있는 생성자
    public User(String id, String pwd, String name, java.util.Date enrollDate {
        /*this(): 같은 클래스 내의 다른 생서자를 호출한다.
        * 반드시 생서자 내부의 '첫 번째 줄'에 작성해야 한다.*/
        this(id, pwd, name);
        this.enrollData = enrollDate;
        System.out.println("모든 필드를 초기화 하는 생성자 호출 됨...");
    }

    /*오버로드의 성립기준 : 같은 1)매개변수 타입, 2)개수, 3)순서*/
    //불성립 : 매개변수 '이름'만 다른 경우 (시그니처 동일)
    public void test(int num2){

    }
}
