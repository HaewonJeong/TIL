package com.ohgiraffers.section06.finalkeyword;

public class Parent {

    //final 메서드를 붙이면 자식 클래스에서 overriding(자식 클래스가 부모 클래스가 정의한 메소드를 재정의하는것)을 할 수 없다.
    public final void coreMethod(){
        System.out.println("이것은 부모의 핵심 로직입니다. 절대 바꾸지 마세요~");
    }
}
