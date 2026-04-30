package com.ohgraffers.practice;

import java.util.Scanner;

/* 정수를 입력받아 1부터 입력받은 정수까지
 * 홀수이면 "수", 짝수이면 "박"이 정수만큼 누적되어 출력되게 작성하시오.
 * -- 입력 예시 --
 * 정수를 입력하세요 : 5
 * -- 출력 예시 --
 * 수박수박수
 * */
public class practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();
        for(int i=1; i<=num; i++){
        if(i%2 == 0)
        {
            System.out.print("박"); //짝수면 박
        }else{
            System.out.print("수"); //홀수면 수
        }
        }
    }
}
