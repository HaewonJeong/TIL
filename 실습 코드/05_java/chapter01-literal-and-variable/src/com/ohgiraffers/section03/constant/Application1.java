package com.ohgiraffers.section03.constant;

public class Application1 {

    public static void main(String[] args){
        /*상수*/

        //상수 선언 시 final 키워드를 앞에 붙인다.
        final int AGE;

        AGE = 20; //초기화 불가

        int sum = AGE;

        /*상수의 명명 규칙
        * 변수의 명명규칙과 컴파일 에러를 발생시키는 규칙은 동일
        * 암묵적인 규칙
        * 1. 모든 문자는 '영문자 대문자' 혹은 '숫자'만 사용
        * 2. '단어와 단어 연결은 언더 스코어(_)' 사용*/

        final int AGE2;
        final int age2; //컴파일 에러가 발생하지 않지만 변수와 구분하기 힘듦

        final int MAX_AGE = 50;

    }


}
