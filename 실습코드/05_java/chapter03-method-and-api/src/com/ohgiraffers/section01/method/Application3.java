package com.ohgiraffers.section01.method;

public class Application3 {
    public static void main(String[] args) {
        /*
        * stack  heap
        * app    Applicaiton app new Applicaiton()
        * - static 메소드는 객체가 아니라 '클래스에 속한 메서드'
        *
        * static 메소드 호출 방법
        * - 클래스명.메소드명();
        * */

        System.out.println(Application3.sumTwoNumbers(10, 20));

        //동일한 클래스 내에
    }

    public static int sumTwoNumbers(int a, int b){
        return a + b;
    }

}
