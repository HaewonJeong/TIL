package com.ohgiraffers.section04.sort;

import java.util.Arrays;
import java.util.Random;

public class Application5 {
    static void main() {
        /*배열과 정렬을 응용하여 중복 없는 로또 번호 생성하기*/
        //1. 6개의 숫자를 담을 배열 생성
        int[] numbers = new int[6];
        //2. 중복되지 않는 난수를 생성하여 배열에 담기
        Random rd = new Random();
        for (int i = 0; i < numbers.length; i++){
            int newRdNum = rd.nextInt(45)+1;
            //중복 검사
            for(int j=0; j<numbers.length; j++){
                if(newRdNum == numbers[j]){ //중복이면
                    //System.out.println("중복: newRdNum:"+newRdNum);
                    newRdNum = rd.nextInt(6)+1; //숫자를 새로 뽑고
                    i=0; //처음부터 다시 포문을 돈다
                    //System.out.println("중복 새 숫자: newRdNum:"+newRdNum);
                    break;
                }
            }
            numbers[i] = newRdNum;
        }
        //3. 정렬하여 출력
        Arrays.sort(numbers);
        for(int num : numbers){
            System.out.print(num+"/");
        }

        /*중복 숫자 없는 로또 번호 생성 선생님 코드*/
        int[] lotto = new int[6];
        for(int i = 0; i<lotto.length;i++){
            lotto[i] = (int) (Math.random()*45)+1;
            for(int j=0; j<i; j++){
                if(lotto[i] == lotto[j]){
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lotto);
        System.out.println(Arrays.toString(lotto));
    }
}
