package com.ohgiraffer.section01.polymorphism;

import javax.sound.midi.Soundbank;

public class Zookeeper {
    public void feed(Cat cat){
        System.out.println("고양이에게");
        cat.eat();
    }
    public void feed(Tiger tiger)
    {
        System.out.println("호랑이에게");
        tiger.eat();
    }

    public void feed(Animal animal){
        animal.eat(); //동적 바인딩: 실제 객체의 eat() 실행
    }
}
