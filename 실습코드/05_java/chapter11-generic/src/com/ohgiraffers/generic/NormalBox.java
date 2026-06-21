package com.ohgiraffers.generic;

public class NormalBox {
    private Object content;

    //Object는 모든 타입의 부모 -> 뭐든 담을 수 있다.
    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
