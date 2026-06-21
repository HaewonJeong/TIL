package com.ohgiraffers.section02.variable;

public class Application1 {

    public static void main(String[] args){

        //Java 기본 자료형(primary type) 8가지
        /*정수를 취급하는 자료형*/
        byte bnum; // 1byte
        short snum; // 2btte
        int inum; //4btye
        long lnum; //8btye

        /*실수를 취급하는 자료형*/
        float fnum; //4btye
        double dnum; //8btye

        /*문자를 취급하는 자료형*/
        char ch; //2byte

        //논리값을 취급하는 자료형
        boolean isTrue; //byte

        //문자열은 다른 방식으로 취급한다.(기본 자료형 X)
        String str; //4btye 참조형

        //변수를 선언하고 난 뒤 최초로 값이 대입되는 것을 '초기화' 라고 한다.
        //선언과 값 대입을 동시에 수행 할 수도 있다.
        isTrue = true; //초기화
        int point = 100;//선언과 동시에 초기화

        System.out.println("포인트: "+point);

    }
}