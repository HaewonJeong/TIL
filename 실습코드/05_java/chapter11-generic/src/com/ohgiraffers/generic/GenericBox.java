package com.ohgiraffers.generic;

//<T> : 타입 파라미터(Type Parameter). T는 타입을 담는 변수 처리
//이 클래스를 사용할 때 T 자리에 실제 타입을 넣는다.
public class GenericBox<T> {

    private T content; //변수명이 'T'일 필요는 없지만, 보통 그렇게 씀.

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
