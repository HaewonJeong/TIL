package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application3 {
    static void main() {
        /*향상된 for문
        * 배열의 내용을 처음부터 끝까지 훑어보는 '읽기 전용 뷰어'*/
        int[] arr = {1,2,3,4,5};
        for(int value: arr){
            value += 10;
            System.out.println("임시 변수 value의 값: "+ value);
        }
        System.out.println(Arrays.toString((arr)));
        for(int i=0; i<arr.length;i++){
            arr[i] += 10;
        }
        System.out.println(Arrays.toString(arr));
    }
}
