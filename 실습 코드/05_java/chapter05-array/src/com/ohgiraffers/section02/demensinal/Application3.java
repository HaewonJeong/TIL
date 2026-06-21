package com.ohgiraffers.section02.demensinal;

import java.util.Scanner;

public class Application3 {
    static void main(String[] args) {
        int[][] scores = {
                {80,77,85},
                {78,60,97},
                {90,80,68}
        };
        //각 학생의 총점과 평균 계산 및 출력
        for(int i=0; i<scores.length; i++){
            int sum = 0;
            for( int j =0 ; j < scores.length ; j++ ){
                sum += scores[i][j]; //현재 학생의 j번째 과목 점수 누적
            }
            double avg = sum / (double)scores[i].length;

            System.out.println( (i+1)+"번 학생의 총점 : " +sum);
            System.out.println( (i+1)+"번 학생의 평균 : " +avg);
        }
        Scanner sc = new Scanner(System.in);

        //학생 수와 과목 수 입력 받기
        System.out.println("학생 수를 입력하세요: ");
        int studentCount = sc.nextInt();

        System.out.println("과목 수를 입력하세요.: ");
        int subjectCount = sc.nextInt();

        //2차원 배열에 할당
        int[][] scores2 = new int[subjectCount][subjectCount];

        //점수 입력 받기
        for(int i = 0; i < subjectCount ; i++){
            System.out.println((i+1)+"번 학생의 점수를 입력하세요: " );
            for(int j = 0 ; j<subjectCount; j++){
                System.out.println(" " + (j+1)+ "번째 과목 점수: ");
                scores2[i][j] = sc.nextInt();
            }
        }
        //점수 출력 하기
        for(int i = 0; i < subjectCount ; i++){
            System.out.print((i+1)+"번 학생의 점수: " );
            for(int j = 0 ; j<subjectCount; j++){
                System.out.print(scores2[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
