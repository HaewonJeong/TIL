package com.ohgiraffers.section07;

public class kindsofvariable {
    /*변수는 선언된 위치에 따라 세 종류로 나뉜다.*/

    //1. 인스턴스 변수(non-static field) - 클래스 영역에 선언
    //new 키워드로 객체 생성과 함께 heap 영역에 생성
    //같은 클래스 내 어느 메서드에서든 접근 가능
    //객체가 살아있을 때 까지만 변수도 산다.
    private int instanceNum;

    //2. 클래스 변수(static field) - 프로그램 시작과 함께 static 영역에 단 하나 생성
    //모든 인스턴스가 공유 한다.
    //프로그램 종료될 때 까지 사라지지 static 영역에서 사라지지 않는다.
    //객체의 살아있음과 관계 없이 산다.
    private static int staticNum;

    //3. 지역 변수(local variable) - 메서드 블록 안에 선언, 메소드가 끝나면 사라짐
    public void method(int num){

        //지역변수와 매개변수 모두 메소드 호출 시 stack 메모리에 생성
        int localNum;

        System.out.println(num);
        //System.out.println(localNum);

        System.out.println(instanceNum);
        System.out.println(staticNum);
    }

    public void method2(){
        System.out.println(instanceNum);
        System.out.println(staticNum);
        //System.out.println(localNum); //지역 변수는 해당 지역(블럭 내)에서만 사용 가능
    }
}
