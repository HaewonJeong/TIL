package com.ohgiraffers.practice.ch2;

public class practice04 {
    public static void main(String[] args) {
        double score = 80.52;
        char grade = 'A';

        if( (int)score >= 90 ) grade = 'A';
        else if( 80 <= (int)score && (int)score <= 90 ) grade = 'B';
        else if( 70 <= (int)score && (int)score <= 80 ) grade = 'C';
        else if( 60 <= (int)score && (int)score <= 70 ) grade = 'D';
        else if( (int)score <= 60 ) grade = 'F';

        System.out.println("홍길동의 이번 점수등급은 "+grade+"입니다.");
    }
}
