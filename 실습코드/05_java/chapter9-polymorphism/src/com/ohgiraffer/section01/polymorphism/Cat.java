package com.ohgiraffer.section01.polymorphism;

public class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("고양이가 생선을 먹는다.");
    }
    public void run(){
        System.out.println("고양이가 달려간다~ 슝~");
    }
    public void cry(){
        System.out.println("고양이가 울음소리를 냅니다~ 야옹~");
    }
    public void jump(){
        System.out.println("고양이가 점프한다. 점프~~");
    }
}
