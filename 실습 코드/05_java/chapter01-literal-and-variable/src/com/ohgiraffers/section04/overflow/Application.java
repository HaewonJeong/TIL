package com.ohgiraffers.section04.overflow;

public class Application {
    public static void main(String[] args){
        /*자료형 별 값의 최대 범위를 벗어나는 경우
        * 발생한 carry를 버림처리 하고 sign bit를 반전시켜 최소값으로 순환시킴*/

        byte num1 = 127; //byte 최대 저장 범위

        num1++; //1 증가

        System.out.println("num1: "+num1); //-128 출력. 최소값으로 순환

        byte num2 = -128;
        num2--;

        System.out.println("num2: "+num2);

        int firstNum = 1000000; //100만
        int secondNum = 700000; //70만

        int multi = firstNum * secondNum;
        System.out.println("multl: "+multi);
        System.out.println("multi = " + multi);//soutv : 위에 작성한 변수 출력 단축키

        //이미 오버 플로우로 처리 된 결과를 변수에 담기 때문에 차이가 없다.
        long longNum = firstNum * secondNum;
        System.out.println("longNum = " + longNum);

        //계산기 처리되기 전에 long 타입으로 자료형을 변경(강제형 변환)
        long result = (long)firstNum * secondNum;
        System.out.println("result = "+result);

        
    }

}
