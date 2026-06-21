package com.ohgiraffers.section01;

public class Application2 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        //정상 케이스
        try {
            et.checkEnoughMoney(1000, 3000);
            System.out.println("상품 구입 가능!");
        } catch (Exception e) {
            System.out.println("상품 구입 불가!");
        }

        //예외 발생 케이스
        try {
            et.checkEnoughMoney(3000,1000);
            System.out.println("상품 구입 가능!!");
        } catch (Exception e) {
            System.out.println("상품 구입 불가!!");
            System.out.println(e.getMessage()); //throw 할 때 넣은 메세지 꺼내기
            e.printStackTrace(); //예외 경로 전체 추적 출력
        }

        System.out.println("프로그램을 종료합니다."); //반드시 실행됨
    }
}
