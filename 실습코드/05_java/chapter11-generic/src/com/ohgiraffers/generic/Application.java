package com.ohgiraffers.generic;

public class Application {
    public static void main(String[] args) {

        NormalBox normalBox = new NormalBox();
        normalBox.setContent("안녕하세요");

        //꺼낼 떄 반드시 강제 형변환
        //Object로 꺼내온 자료형을 String에 다운캐스팅 없이 담으면 에러
        //String content = normalBox.getContent();
        String content = (String)normalBox.getContent();

        normalBox.setContent(123); //실수로 숫자를 넣어도 컴파일 에러 안남

        //String wrongContent = (String) normalBox.getContent();
        GenericBox<String> stringBox = new GenericBox<>();

        stringBox.setContent("hello world");
        String strContent = stringBox.getContent();
        System.out.println("strContent = " + strContent);

        //제네릭에 들어가는 타입은 반드시 '객체 타입(참조형)'이어야 한다.
        //내부적으로 타입을 Object로 다루기 때문에, 기본형은 object로 업캐스팅 할 수 없다.
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setContent(100);

        int intContent = integerBox.getContent(); //auto-unboxing으로 int 변수에 담기 가능

    }
}
