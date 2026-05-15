package com.ohgiraffers.section01.intro;

@FunctionalInterface //해당 인터페이스는 메소드가 하나만 정의 되어야 한다는 함수형 인터페이스를 표시한 어노테이션
//함수형 인터페이스 : 메소드가 단 하나만 정의된 인터페이스(람다식 사용의 필수 조건)
public interface Calculator {

    int sumTwoNumber(int a, int b);

}
