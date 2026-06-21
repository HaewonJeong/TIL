package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application1 {
    static void main() {
        /*변수의 두 값을 변경하는 방법*/
        int num1 = 10;
        int num2 = 20;

        int temp;
        temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("num1 :"+num1 + "num2 :"+num2);
        int[] arr = {2,1,3};
        int temp2 = arr[0];
        arr[0] = arr[1];
        arr[1] = temp2;

        System.out.println(Arrays.toString(arr));
    }
}
