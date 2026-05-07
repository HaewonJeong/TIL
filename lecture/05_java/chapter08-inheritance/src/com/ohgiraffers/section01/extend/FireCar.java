package com.ohgiraffers.section01.extend;

//부모의 기능을 모두 물려받는다.
//오버라이드를 이용해 입맛에 맞게 재정의 가능
public class FireCar extends Car{
    public FireCar() {
        super(); //부모의 기본 생성자를 호출
        System.out.println("FireCar의 기본 생성자 호출");
    }

    //Alt+insert > 메서드 재정의 > soundHorn 선택
    /*@Override 어노테이션
    부모 클래스로부터 물려 받은 메소드를 나에게 맞게 재정의 하는 것을 의미
    * 이 어노테이션을 붙이면, 컴파일러가 오버라이딩 규칙을 잘 지켰는지 검사해준다.(실수 방지)
    * */
    @Override
    public void soundHorn() {
        if(isRunning()){
            System.out.println("빠아아아아아아아아앙!@!@!@!@");
        }else {
            System.out.println("소방차가 앞으로 갈 수 없습니다 비키세요 비켜~~~~~~~~~");
        }
    }

    //부모에게 없는 고유한 기능 추가(확장)
    public void sparyWater(){
        System.out.println("불난곳을 발견했습니다, 물을 뿌립니다 ==========>>>>>");
    }
}
