package com.ohgiraffers.practice;

import java.util.Scanner;

/* 홀수인 양의 정수를 입력 받아 입력 받은 크기 만큼의 정수형 배열을 할당하고
 * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값 넣어 출력하세요
 *
 * 단, 홀수인 양의 정수를 입력하지 않은 경우에는 "양수 혹은 홀수만 입력해야 합니다."를 출력하세요
 *
 * -- 입력 예시 --
 * 홀수인 양의 정수를 입력하세요 : 7
 *
 * -- 출력 예시 --
 * 1 2 3 4 3 2 1
 *
 * -- 입력 예시 --
 * 홀수인 양의 정수를 입력하세요 : 8
 *
 * -- 출력 예시 --
 * 양수 혹은 홀수만 입력해야 합니다.
 */
public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = 0;

        System.out.print("홀수인 양의 정수를 입력하세요 : ");
        length = sc.nextInt();
        if ( length % 2 == 0 || length <= 0) //홀수인 양의 정수가 아닐때
        {
            System.out.print("양수 혹은 홀수만 입력해야 합니다.");
            return;
        }

        int[] arr = new int[length];

        int cnt = 1;
        for(int i = 0 ; i < arr.length; i++){
            if( i+1 <= arr.length/2 )
            {
                arr[i] = cnt++;
            }
            else {
                arr[i] = cnt--;
            }
        }

        for (int j : arr){
            System.out.print(j+" ");
        }
        return;

    }
}
