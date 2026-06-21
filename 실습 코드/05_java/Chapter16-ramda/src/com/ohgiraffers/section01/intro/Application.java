package com.ohgiraffers.section01.intro;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Application {

    static void main() {
        /*람다식은 메소드가 하나뿐인 인터페이스의 구현을 짧게 쓰게 해주는 문법*/

        //1. 전통 방식
        Calculator c1 = new CalculatorImpl();
        System.out.println(c1.sumTwoNumber(10,20));

        //2. 익명 클래스 방식
        Calculator c2 = new Calculator() {
            @Override
            public int sumTwoNumber(int a, int b) {
                return a + b;
            }
        };

        //3. 람다식
        //(파라미터) -> 리턴 구문;
        Calculator c3 = (x, y) -> x + y;
        //람다식 사용
        System.out.println(c3.sumTwoNumber(10,20));

        //int와 int를 받아 반환하는 것처럼 흔한 함수 모양은
        //java.util.fuction 패키지에 표준 함수형 인터페이스로 준비되어 있다.

        //BiFunction<T, U, R> : T, U 두 인수를 받아 R 타입 반환
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y ;
        System.out.println( sum.apply(100, 200));

        //Consumer<T> : T를 받아 처리만 하고 반환 없음
        List<String> names = Arrays.asList("홍길동","유관순","이순신");

        for(String name : names){
            System.out.println(name);
        }

        Consumer<String> printName =  name -> System.out.println("환영합니다 "+name+"님~");
        //forEach : 리스트의 각 요소를 하나씩 꺼내 전달받은 printName이라는 Consumer에 넘겨준다.
        //printName에 담긴 람다식이 각 요소마다 실행 됨
        names.forEach(printName);

        //더 짧게 줄이기
        names.forEach(name -> System.out.println("환영합니다 "+name+"님~"));

        //외부 지역 변수를 람다식에 사용
        String prefix = "[회원]";
        names.forEach(name-> System.out.println(prefix + " " + name));

        //prefix = "[고객]";
        //익명 클래스 또는 람다식에서는 참조하는 외부 지역 변수가 final로 선언됐거나 선언된 후 참조가 변경되지 않는 effectively final인 경우에만 접근 가능



    }
}
