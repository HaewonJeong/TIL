package com.ohgiraffers.section01;

public class Application {
    public static void main(String[] args) throws Exception{
        //예외처리를 나를 호출하는 시점으로 위임.
        //JVM까지 가서 프로그램이 비정상 종료 처리 된다.
        ExceptionTest et = new ExceptionTest();

        System.out.println("==정상 케이스==");
        et.checkEnoughMoney(10000,50000); //Exception 발생!!

        System.out.println("==비정상 케이스==");
        et.checkEnoughMoney(500000,5000); //Exception 발생!!

        System.out.println("프로그램을 종료합니다.");//예외가 발생하면 이 줄은 실행 안됨
    }
}

