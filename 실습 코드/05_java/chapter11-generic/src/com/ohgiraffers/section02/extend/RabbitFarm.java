package com.ohgiraffers.section02.extend;

// 제한된 타입 파라미터
// T는 Rabbit 또는 Rabbit의 자손 만 가능하도록 타입을 제한한다.
public class RabbitFarm<T extends Rabbit> {

    private T animal;

    public RabbitFarm() {
    }

    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
