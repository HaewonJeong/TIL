package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application2 {
    /**
     * [선택 정렬]
     * 가장 작은 값을 찾아 맨 앞으로 보내는 과정을 반복하는 정렬.
     * 데이터 양이 적을 떄 좋은 성능을 나타낸다. (교환 횟수가 적음)
     * 하지만 배열을 전부 탐색하여 최솟값을 찾아야하기 때문에 100개 이상의 자료에서는 급격하게 속도가 저하된다.
     */
    static void main() {
        int[] arr = {2, 5, 4, 6, 1, 3};
        System.out.println("정렬 전: "+ Arrays.toString(arr));
        for(int i = 0 ; i < arr.length -1 ; i++){
            int minIndex = i; //일단 현재 자리(i)에 있는 값이 가장 작다고 가정
            for (int j = i; j < arr.length; j++){
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println((i+1)+"회차 정렬 후 : "+Arrays.toString(arr));
        }

    }

}
