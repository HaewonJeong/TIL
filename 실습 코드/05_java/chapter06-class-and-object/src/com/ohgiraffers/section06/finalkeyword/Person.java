package com.ohgiraffers.section06.finalkeyword;

public class Person {
    //final 인스턴스(객체) 필드 : 객체 생성 시 딱 한 번 결정, 이후 결정 불가
    final String ssn; //주민등록번호 - 평생 바뀌지 않는 값
    private String name;

    //alt+insert로 getter, setter 추가.
    //final 필드에 대해서는 setter 메서드가 추가되지 않음
    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String ssn, String name){
        this.ssn = ssn; //객체 생성하면서 초기화하는 구문 추가 하고 빨간줄 사라짐
        this.name = name;
    }
}
