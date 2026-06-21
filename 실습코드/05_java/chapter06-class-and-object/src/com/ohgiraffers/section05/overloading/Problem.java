package com.ohgiraffers.section05.overloading;

public class Problem {
    public static void main(String[] args) {

        BadCalculator bc = new BadCalculator();

        System.out.println(bc.addTowInts(10, 20));
        bc.addTwoDoubles(10.5, 20.5);
        bc.addThreeInts(10, 20, 30);
    }
}
