package com.ohgiraffers.section01.extend;

public class RacingCar extends Car{
    @Override
    public void run() {
        super.run(); //부모의 run() 메소드 실행
        System.out.println("레이싱카가 전속력으로 질주합니다!!!!!!");
    }
}
