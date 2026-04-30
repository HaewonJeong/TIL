package com.ohgraffers.section02.looping;

import java.awt.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        //app.whyNeedLoops();
        //app.nestedForLoop();
        //app.nestedForLoop2();
        app.whileLoop();
    }

    public void whyNeedLoops(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1번째 학생의 이름 : ");
        String student1 = sc.nextLine();
        System.out.println("1 번째 학생의 이름은 "+student1+"입니다.");

        System.out.println("2번째 학생의 이름 : ");
        String student2 = sc.nextLine();
        System.out.println("2 번째 학생의 이름은 "+student2+"입니다.");

        for (int i = 1 ; i <=5 ;i++ ){
            System.out.println(i+"번째 학생의 이름 :");
            String student = sc.nextLine();
            System.out.println(i+"번째 학생의 이름은 "+student+"입니다.");
        }

    }
    //요오드 -> 아이오딘, 아밀라아제 -> 아밀레이스, 게르마늄->저마늄, 나트륨->소듐, 칼륨 -> 포타슘, 부탄 -> 뷰테인, 스티로폼->스타이로폼, 실로폰->글로켄슈켄
    //누적 합계 구하기
    public void forLoopSum(){
        //1부터 사용자가 입력한 숫자까지의 합계 구하기
        Scanner sc1 = new Scanner(System.in);
        System.out.print("합계를 구할 양의 정수를 입력 :");
        int num = sc1.nextInt();

        int sum = 0;
        for(int i = 1; i<=3; i++){
            sum += 1;
        }
        System.out.println("1부터 "+num+"까지의 합: "+sum);
    }
    //중첩 for문 - 구구단
    public void nestedForLoop(){
        //바깥쪽 for문 - 단(2~9)를 제어
        for(int dan = 2 ; dan <= 9; dan++)
        {
            //안쪽 for문 : 곱하는 수(1~9)를 제어
            for(int su = 1; su <= 9 ; su++){
                System.out.println(dan+" * "+su+" = "+dan*su);
            }

        }
    }
    //중첩 for문 - 구구단
    public void nestedForLoop2(){
        Scanner sc2 = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 :");
        int rows = sc2.nextInt();
        //입력 받은 줄(rows) 수만큼 반복하기
        for(int i = 0 ; i < rows ; i++)
        {
            //i번째 줄에서 별을 i번 찍는다.
            for(int j = rows-i; j <= rows ; j++) { //각 행에 찍을 별 갯수
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // while문
    public void whileLoop(){
        Scanner sc1 = new Scanner(System.in);
        String str = "";

        //equals() : 문자열의 내용이 같은지 비교하는 메소드
        while(!str.equals("exit")){
            System.out.print("문자열을 입력하세요.('exit' 입력 시 종료) :");
            str = sc1.nextLine();
            System.out.println("입력한 문자열: "+str);
        }
        System.out.println("프로그램을 종료합니다.");
    }
    //do-while 문
    public void whileLoop2(){
        Scanner sc = new Scanner(System.in);
        String str;
        do{
            System.out.print("문자열을 입력하세요.('exit' 입력 시 종료) :");
            str = sc.nextLine();
            System.out.println("입력한 문자열: "+str);
        }
        while(!str.equals("exit"));
        System.out.println("프로그램을 종료합니다.");

    }

}
