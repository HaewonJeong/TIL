package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application3 {
    static void main() {
        /*
        * [버블 정렬] - 물 속의 거품이 가벼울수록 위로 올라오는 현상과 같아서 버블 정렬
        * 인접한 두 원소를 비교하여, 큰 값을 오른쪽으로*2 계속해서 이동시킨다.
        * 한 회차가 끝나면 가장 큰 값이 배열의 맨 뒤에 위치하게 된다.
        *
        * */
        int[] arr = {2,5,4,6,1,3};

        // i : 정렬이 확정된 영역의 시작 인덱스 (뒤에서 부터)
        for(int i = arr.length - 1; i >= 0; i--){
            //j : 비교할 대상의 인덱스 (앞에서 부터)
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){ //앞과 뒤 비교
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
                System.out.println((arr.length - i) + "회차 정렬 후 : " + Arrays.toString(arr));
            }
            System.out.println("정렬 후 : "+ Arrays.toString(arr));
        }
    }
}
