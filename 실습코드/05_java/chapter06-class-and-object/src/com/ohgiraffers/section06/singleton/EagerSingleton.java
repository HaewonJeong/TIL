package com.ohgiraffers.section06.singleton;

import javax.swing.*;

public class EagerSingleton {

    //클래스가 로딩되는 즉시 인스턴스를 딱 하나 미리 만들어 보관
    private static EagerSingleton eager = new EagerSingleton();

    //외부에서 new로 못 만들게 생성자를 private로 잠근다.
    private EagerSingleton(){}

    //유일한 객체를 건네주는 공개 창구
    public static EagerSingleton getInstance(){
        return eager;
    }
}

/*
클래스에 싱글톤 패턴을 적용하는 것은 전혀 복잡하지 않다.
어렵게 생각할 필요없이 싱글톤으로 이용할 클래스를 외부에서 마구잡이로 new 생성자를 통해 인스턴스화 하는 것을 제한하기 위해
클래스 생성자 메서드에 private 키워드를 붙여주면 된다.
그리고 위 그림에서 볼 수 있듯이 getInstance() 라는 메서드에 생성자 초기화를 해주어,
만일 클라이언트가 싱글톤 클래스를 생성해서 사용하려면 getInstance() 라는 메서드 실행을 통해
instance 필드 변수가 null 일경우 초기화를 진행하고 null이 아닐경우 이미 생성된 객체를 반환하는 식으로 구성하면 된다.
출처: https://inpa.tistory.com/entry/GOF-💠-싱글톤Singleton-패턴-꼼꼼하게-알아보자 [Inpa Dev 👨‍💻:티스토리]
* */
