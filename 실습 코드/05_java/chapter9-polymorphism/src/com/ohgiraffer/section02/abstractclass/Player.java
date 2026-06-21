package com.ohgiraffer.section02.abstractclass;

// abstract: 이 클래스는 미완성 설계도 이다.
public abstract class Player {
    //일반 메서드를 쓰면 자식이 오버라이딩을 '깜빡' 할 수 있다.
//    public void attack(){
//        System.out.println("플레이어가 공격합니다.");
//    }

    //추상 메서드: 몸통({})이 없다. '이 기능이 필요하다.'는 선언만 있는 미완성 메서드
    //추상 클래스를 상속 받는 모든 자식은 반드시 추상 메서드를 직접 구현해야한다.
    //추상 클래스는 아이콘이 네군데가 뚫려있음
    public abstract void attack();

    //추상 클래스도 일반 메서드를 가질 수 있다.
    //모든 캐릭터의 공통 동작 - 오버라이딩 강제 아님
    public void levelUp(){
        System.out.println("레벨업!");
    }

}
