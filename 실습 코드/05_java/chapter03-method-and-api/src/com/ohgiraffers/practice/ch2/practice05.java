package com.ohgiraffers.practice.ch2;

public class practice05 {
    public static void main(String[] args) {
        int month = 1, day = 1;

        if( (1 <= month && month <=6)&&(1 <= day && day <=15) ){
            System.out.println("정해원의 선물은 배민 쿠폰 입니다~~!🛵");
        }else if( (7 <= month && month <=12)&&(16 <= day && day <=31) ){
            System.out.println("정해원의 선물은 스타벅스 커피 입니다~~!☕");
        }else{
            System.out.println("정해원의 선물은 사탕 입니다~~!🍭");
        }
    }
}
