package com.ohgiraffers.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/* 숫자 야구게임 만들기
 * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
 * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
 * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
 * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
 *
 * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
 * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
 *
 * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
 * 횟수는 차감하지 않는다.
 *
 * -- 프로그램 예시 (난수 7416 의 경우) --
 *
 * 10회 남으셨습니다.
 * 4자리 숫자를 입력하세요 : 1234
 * 아쉽네요 0S 2B 입니다.
 * 9회 남으셨습니다.
 * 4자리 숫자를 입력하세요 : 5678
 * 아쉽네요 0S 2B 입니다.
 * 8회 남으셨습니다.
 * 4자리 숫자를 입력하세요 : 7416
 * 정답입니다.
 * */
public class practice2 {
    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-1};
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < arr.length ; i++){
            int score = (int)(Math.random() * 9); //score를 일단 하나 뽑는다.
            //0번 칸부터 지금 채우려는 i번 칸 앞까지 쭉 훑으며 score랑 똑같은 게 있는지 검사한다.
            boolean isDuplicate = false;
            for( int s = 0 ; s < i ; s++){
                if( score == arr[s] ) { //똑같은 게 있다면, true로 바꿈
                    isDuplicate = true;
                }
            }
            if(isDuplicate == true){ //중복이면 다시 뽑는다.
                i--;
            }else{arr[i] = score; } //중복이 아니면 배열에 저장한다.

        }
        int cnt = 10;
            while(cnt > 0){
                System.out.println(Arrays.toString(arr));
                System.out.println(cnt-- + "회 남으셨습니다");
                System.out.print("4자리 숫자를 입력하세요 : ");
                int respond = sc.nextInt();
                int[] digits = Stream.of(String.valueOf(respond).split("")).mapToInt(Integer::parseInt).toArray();
                if( digits.length != 4) {
                    System.out.println("4자리의 정수를 입력해야 합니다.");
                    cnt++;
                    continue;
                }
                int s = 0, b = 0;
                //숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼
                for (int i = 0; i < arr.length; i++) {
                    int currunt = arr[i];
                    for (int j = 0; j < digits.length; j++) {
                        if (currunt == digits[j]) {
                            if (i == j) {
                                s++;
                                b++;
                            } else {
                                b++;
                            }
                        }
                    }
                }
                if (s != 4) System.out.println("아쉽네요 " + s + "S " + b + "B 입니다.");
                else {
                    System.out.println("정답입니다. 게임을 종료합니다...");
                    break;
                }
            }
        }
    }

