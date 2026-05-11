package com.ohgiraffers.section01.list.run;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        /**
         * 컬렉션 프레임워크란
         * 여러 개의 데이터(객체)를 효과적으로 관리하기 위해 자바에서 제공하는 클래스들의 묶음
         * 크게 List, Set, Map 인터페이스로 분류한다.
         */

        // alist = new ArrayList<>();
        //제네릭 없는 리스트
        List alist = new ArrayList<>(); //실무에서는 자료형이 바껴도 영향 받지 않기 위해 상위 클래스를 선언
        alist.add("apple");
        alist.add(123);
        alist.add(45.67);
        alist.add(false);

        System.out.println(alist);

        //String fruit = alist.get(0); //컴파일 에러
        //1)ArrayList 값 가져오기
        String fruit = (String)alist.get(0); //강제 형변환 필요

        //2)ArrayList 값 추가
        List<String> stringList = new ArrayList<>();
        stringList.add("banana");
        stringList.add("orange");
        stringList.add("mango");

        System.out.println(stringList); //순서 유지

        //3)ArrayList 인덱스 위치의 값 수정
        //set(인덱스, 값) - 해당 위치 수정
        stringList.set(0, "apple");
        System.out.println(stringList);

        //4)ArrayList 값 삭제
        stringList.remove(1);
        System.out.println(stringList);

        //5)size - 현재 몇 개 들어있는지 확인
        System.out.println(stringList.size());

        stringList.add("banana");
        System.out.println(stringList);

        //오름차순 정렬
        Collections.sort(stringList);
        System.out.println(stringList);



    }

}
