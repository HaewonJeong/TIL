package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {
        /*다른 클래스에서 작성한 메소드 호출*/
        /*non-static 메소드의 경우
        * 클래스가 다르더라도 사용 방법 동일
        * 클래스명 사용할 이름 = new 클래스명();
        * 사용할 이름.메소드명();
        * */

        Calculator calc = new Calculator();
        int min = calc.minNumberOf(20, 5);
        System.out.println(min);

        /*static 메소드의 경우
        * 다른 클래스에 작성한 static 메소드의 경우 호출할 때 '클래스명' 반드시 기술
        * 클래스명.메소드명();*/

        int max = Calculator.maxNumberOf(25,18);
        System.out.println("max = "+ max);

        int max2 = calc.maxNumberOf(3,1); //객체로 접근 할 수 있지만 권장하지 않음!
        System.out.println("max2 = "+ max2);
    }
}
