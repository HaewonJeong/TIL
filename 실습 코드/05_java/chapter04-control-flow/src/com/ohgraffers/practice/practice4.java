package com.ohgraffers.practice;

import java.util.Random;
import java.util.Scanner;

public class practice4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 :" );
        int num = sc.nextInt();
        Random rd = new Random();
        //int rdInt = rd.nextInt();

        boolean isEnd = true;
        int cnt = 0;
        while(isEnd){
            int rdInt = (rd.nextInt(100))+1; //1~100까지
            cnt++;
            if(0 >= num || num > 100){ //예외처리
                    System.out.println("1~100 사이의 수를 입력해주세요!");
                    isEnd = false;
            }
            else if(num > rdInt){
                System.out.println("입력하신 정수보다 큽니다. 생성된 랜덤 수 :"+rdInt);
            }else if(num < rdInt){
                System.out.println("입력하신 정수보다 작습니다.  생성된 랜덤 수 :"+rdInt);
            }else if(num == rdInt){
                System.out.println("정답입니다. "+cnt+"회만에 정답을 맞추셨습니다. 생성된 랜덤 수 :"+rdInt);
                isEnd = false;
            }
    }
    }
}
