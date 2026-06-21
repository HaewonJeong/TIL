package com.ohgiraffers.section01.init;

public class Car {

    private String modelName;
    private int maxSpeed;

    //Alt+Insert > '생성자' 선택 > 생성자 자동 입력
    public Car(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    public void driveMaxSpeed(){
        System.out.println(this.modelName + "이(가) 최고 시속 "+this.maxSpeed + "km/h로 달려갑니다.");
    }

    public String getModelName() {
        return modelName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
