package com.ohgiraffers.section05.overloading;

public class Solution {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // 자바가 인자를 보고 알맞는 메서드를 '알아서' 찾아준다.
        System.out.println(calc.add(10, 20));
        System.out.println(calc.add(10.5, 20.5));
        System.out.println(calc.add(10, 20, 30));
    }
}
